package com.practica.master.models.service;

import com.practica.master.exception.exceptions.TrainingResourceDeletedException;
import com.practica.master.exception.exceptions.TrainingResourceNoCreateException;
import com.practica.master.exception.exceptions.TrainingResourceNoExistsException;
import com.practica.master.exception.exceptions.TrainingResourceNoUpdateException;
import com.prueba.commons.proyecto.models.entity.Area;

import java.util.List;

public interface IAreaService {

    List<Area> findByAll() throws TrainingResourceNoExistsException;

    List<Area> findByEstado(Boolean estado) throws TrainingResourceNoExistsException;

    Area findById(Long id) throws TrainingResourceNoExistsException;

    Area crear(Area area) throws TrainingResourceNoCreateException;

    Area editar(Long id, Area area) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException;

    void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException;

    Area estado(Long id, Boolean estado) throws TrainingResourceNoExistsException;

}
