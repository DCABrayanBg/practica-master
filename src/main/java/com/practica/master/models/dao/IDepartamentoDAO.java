package com.practica.master.models.dao;


import com.prueba.commons.proyecto.models.entity.Departamento;
import com.prueba.commons.proyecto.models.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentoDAO extends CrudRepository<Departamento,Long> {

    Departamento findByNameIgnoreCaseContaining(String name);

    List<Departamento> findByPais(Pais pais);
}
