package com.practica.master.models.service.implement;

import com.prueba.commons.proyecto.models.entity.Fondo;
import com.prueba.commons.proyecto.models.entity.TipoReferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoReferenciaServicio {

    @Autowired
    TipoReferencia tipoReferencia;

    @Autowired
    Fondo fondo;
}
