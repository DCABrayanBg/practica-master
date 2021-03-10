package com.practica.master.models.dao;


import com.prueba.commons.proyecto.models.entity.Area;
import com.prueba.commons.proyecto.models.entity.Contrato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContratoDAO extends CrudRepository<Contrato,Long> {

    Contrato findByCodigoIgnoreCaseContaining(String name);

    List<Contrato> findByArea(Area area);

    List<Contrato> findByValor_Salario(double salario);
}
