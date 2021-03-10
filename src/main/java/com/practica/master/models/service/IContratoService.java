package com.practica.master.models.service;

import com.practica.master.exception.exceptions.*;
import com.prueba.commons.proyecto.models.entity.Area;
import com.prueba.commons.proyecto.models.entity.Contrato;

import java.util.List;

public interface IContratoService {

    List<Contrato> findByAll() throws TrainingResourceNoExistsException;

    Contrato findById(Long id) throws TrainingResourceNoExistsException;

    Contrato crear(Contrato Contrato) throws TrainingResourceNoCreateException;

    Contrato editar(Long id, Contrato Contrato) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException;

    void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException;

    Contrato findByCodigoIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException;

    List<Contrato> findByArea(Area area) throws TrainingResourceNotFoundException;

    List<Contrato> findByValor_Salario(double salario) throws TrainingResourceNotFoundException;

}
