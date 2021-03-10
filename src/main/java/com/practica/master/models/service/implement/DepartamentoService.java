package com.practica.master.models.service.implement;

import com.practica.master.exception.exceptions.TrainingResourceNoCreateException;
import com.practica.master.exception.exceptions.TrainingResourceNoExistsException;
import com.practica.master.exception.exceptions.TrainingResourceNoUpdateException;
import com.practica.master.exception.exceptions.TrainingResourceNotFoundException;
import com.practica.master.models.dao.IDepartamentoDAO;
import com.practica.master.models.service.IDepartamentoService;
import com.prueba.commons.proyecto.models.entity.Departamento;
import com.prueba.commons.proyecto.models.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamentoDAO dao;

    private Departamento departamento;

    @Override
    public List<Departamento> findByAll() throws TrainingResourceNotFoundException {
        if (dao.findAll()==null) throw new TrainingResourceNotFoundException();
        return (List<Departamento>) dao.findAll();
    }

    @Override
    public List<Departamento> findByPais(Pais p) throws TrainingResourceNotFoundException {
        if (dao.findByPais(p)==null) throw new TrainingResourceNotFoundException();
        return (List<Departamento>) dao.findByPais(p);
    }

    @Override
    public Departamento findById(Long id) throws TrainingResourceNoExistsException {
        departamento = dao.findById(id).orElse(null);
        if (departamento==null) throw new TrainingResourceNoExistsException();
        return departamento;
    }

    @Override
    public Departamento findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException {
        departamento = dao.findByNameIgnoreCaseContaining(name);
        if (departamento==null) throw new TrainingResourceNoExistsException();
        return departamento;
    }

    @Override
    public Departamento crear(Departamento Departamento) throws TrainingResourceNoCreateException {
        try {
            return dao.save(Departamento);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Departamento editar(Long id, Departamento departament) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        departamento = findById(id);
        departamento.setName(departament.getName());
        departamento.setPais(departament.getPais());

        try {
            return dao.save(departamento);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceNoExistsException {
        departamento = findById(id);
        dao.delete(departamento);
    }
}
