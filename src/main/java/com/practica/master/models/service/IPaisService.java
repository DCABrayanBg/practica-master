package com.practica.master.models.service;

import com.practica.master.exception.exceptions.*;
import com.prueba.commons.proyecto.models.entity.Pais;

import java.util.List;

public interface IPaisService {
    List<Pais> findByAll() throws TrainingResourceNotFoundException;

    Pais findById(Long id) throws TrainingResourceNoExistsException;

    Pais crear(Pais Pais) throws TrainingResourceNoCreateException;

    Pais editar(Long id, Pais Pais) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException;

    void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException;

    Pais findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException;

}
