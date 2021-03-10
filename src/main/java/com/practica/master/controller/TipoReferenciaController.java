package com.practica.master.controller;

import com.prueba.commons.proyecto.models.entity.TipoReferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoReferencia")
public class TipoReferenciaController {


    @Autowired
    TipoReferencia tipoReferencia;
}
