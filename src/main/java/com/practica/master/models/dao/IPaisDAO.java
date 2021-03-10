package com.practica.master.models.dao;


import com.prueba.commons.proyecto.models.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisDAO  extends CrudRepository<Pais,Long> {
    Pais findByNameIgnoreCaseContaining(String name);
}
