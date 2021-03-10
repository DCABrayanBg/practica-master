package com.practica.master.models.service.implement;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.dao.ICiudadDAO;
import com.practica.master.models.service.ICiudadService;
import com.prueba.commons.proyecto.models.entity.Ciudad;
import com.prueba.commons.proyecto.models.entity.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService implements ICiudadService {

    @Autowired
    private ICiudadDAO dao;

    private Ciudad ciudad;

    @Override
    public List<Ciudad> findByAll() throws TrainingResourceNoExistsException {
        if (dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Ciudad>) dao.findAll();
    }

    @Override
    public List<Ciudad> findByDepartamento(Departamento d) throws TrainingResourceNotFoundException {
        if (dao.findByDepartamento(d)==null) throw new TrainingResourceNotFoundException();
        return (List<Ciudad>) dao.findByDepartamento(d);
    }

    @Override
    public Ciudad findById(Long id) throws TrainingResourceNoExistsException {
        ciudad = dao.findById(id).orElse(null);
        if (ciudad==null) throw new TrainingResourceNoExistsException();
        return ciudad;
    }

    @Override
    public Ciudad findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException {
        ciudad = dao.findByNameIgnoreCaseContaining(name);
        if (ciudad==null) throw new TrainingResourceNoExistsException();
        return ciudad;
    }

    @Override
    public Ciudad crear(Ciudad ciudad) throws TrainingResourceNoCreateException {
        try{
            return dao.save(ciudad);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Ciudad editar(Long id, Ciudad city) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        ciudad = findById(id);
        ciudad.setDepartamento(city.getDepartamento());
        ciudad.setName(city.getName());
        try {
            return dao.save(ciudad);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        ciudad = findById(id);

        try{
            dao.delete(ciudad);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }
}
