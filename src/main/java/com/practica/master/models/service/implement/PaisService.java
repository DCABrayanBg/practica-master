package com.practica.master.models.service.implement;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.dao.IPaisDAO;
import com.practica.master.models.service.IPaisService;
import com.prueba.commons.proyecto.models.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService implements IPaisService {
    @Autowired
    private IPaisDAO dao;

    private Pais pais;

    @Override
    public List<Pais> findByAll() throws TrainingResourceNotFoundException {
        if (dao.findAll()==null) throw new TrainingResourceNotFoundException();
        return (List<Pais>) dao.findAll();
    }

    @Override
    public Pais findById(Long id) throws TrainingResourceNoExistsException {
        pais = dao.findById(id).orElse(null);
        if (pais==null) throw new TrainingResourceNoExistsException();
        return pais;
    }

    @Override
    public Pais findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException {
        pais = dao.findByNameIgnoreCaseContaining(name);
        if (pais==null) throw new TrainingResourceNoExistsException();
        return pais;
    }

    @Override
    public Pais crear(Pais p) throws TrainingResourceNoCreateException {
        try {
            return dao.save(p);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Pais editar(Long id, Pais Pais) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        pais = findById(id);
        pais.setName(Pais.getName());
        try {
            return dao.save(pais);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        pais = findById(id);
        try {
            dao.delete(pais);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }
}
