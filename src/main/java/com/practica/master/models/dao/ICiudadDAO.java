package com.practica.master.models.dao;

import com.prueba.commons.proyecto.models.entity.Ciudad;
import com.prueba.commons.proyecto.models.entity.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadDAO extends CrudRepository<Ciudad,Long> {

    Ciudad findByNameIgnoreCaseContaining(String name);

    List<Ciudad> findByDepartamento(Departamento departamento);
}
