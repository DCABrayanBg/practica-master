package com.practica.master.models.service;

import com.practica.master.exception.exceptions.*;
import com.prueba.commons.proyecto.models.entity.Ciudad;
import com.prueba.commons.proyecto.models.entity.Departamento;

import java.util.List;

public interface ICiudadService {
    List<Ciudad> findByAll() throws TrainingResourceNoExistsException;

    Ciudad findById(Long id) throws TrainingResourceNoExistsException;

    Ciudad crear(Ciudad Ciudad) throws TrainingResourceNoCreateException;

    Ciudad editar(Long id, Ciudad Ciudad) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException;

    void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException;

    Ciudad findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException;

    List<Ciudad> findByDepartamento(Departamento departamento) throws TrainingResourceNotFoundException;

}
