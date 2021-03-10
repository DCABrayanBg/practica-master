package com.practica.master.controller;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.service.IPaisService;
import com.prueba.commons.proyecto.models.entity.Pais;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pais/")
public class PaisController {
    @Autowired
    private IPaisService paisSer;

    @ApiOperation(value = "Retorna lista de Paises", notes = "<br>Retorna una lista con todos los Paises registrados en la BD"
            , response = Pais.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Pais> findAll() throws TrainingResourceNotFoundException {
        return paisSer.findByAll();

    }

    @ApiOperation(value = "Retorna un Pais", notes = "<br>Retorna un Pais atraves del ID"
            , response = Pais.class, responseContainer = "Pais", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Pais finById(@PathVariable Long id) throws TrainingResourceNoExistsException {
        return paisSer.findById(id);
    }

    @ApiOperation(value = "Retorna un Pais", notes = "<br>Retorna un Pais atraves del nombre"
            , response = Pais.class, responseContainer = "Pais", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/name/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Pais findByName(@PathVariable String name) throws TrainingResourceNoExistsException {
        return paisSer.findByNameIgnoreCaseContaining(name);
    }

    @ApiOperation(value = "Crea un Pais", notes = "<br>Crea un Pais recibiendo un objeto Pais"
            , response = Pais.class, responseContainer = "Pais", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais crear(@RequestBody Pais a) throws TrainingResourceNoCreateException {
        return paisSer.crear(a);
    }

    @ApiOperation(value = "Actualiza la informacion de un Pais", notes = "<br>Actualiza la informacion de un Pais atraves del ID"
            , response = Pais.class, responseContainer = "Pais", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais edit(@RequestBody Pais a, @PathVariable Long id) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        return paisSer.editar(id,a);
    }


    @ApiOperation(value = "Elimina un Pais", notes = "<br>Elimina un Pais atraves del ID"
            , response = Pais.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Pais.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        paisSer.delete(id);
    }
}
