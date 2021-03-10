package com.practica.master.models.service;

import com.practica.master.exception.exceptions.TrainingResourceNoCreateException;
import com.practica.master.exception.exceptions.TrainingResourceNoExistsException;
import com.practica.master.exception.exceptions.TrainingResourceNoUpdateException;
import com.practica.master.exception.exceptions.TrainingResourceNotFoundException;
import com.prueba.commons.proyecto.models.entity.Departamento;
import com.prueba.commons.proyecto.models.entity.Pais;

import java.util.List;

public interface IDepartamentoService {
    List<Departamento> findByAll() throws TrainingResourceNotFoundException;

    Departamento findById(Long id) throws TrainingResourceNoExistsException;

    Departamento crear(Departamento Departamento) throws TrainingResourceNoCreateException;

    Departamento editar(Long id, Departamento Departamento) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException;

    void delete(Long id) throws TrainingResourceNoExistsException;

    Departamento findByNameIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException;

    List<Departamento> findByPais(Pais p) throws TrainingResourceNotFoundException;
}
