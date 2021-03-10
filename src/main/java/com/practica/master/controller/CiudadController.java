package com.practica.master.controller;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.service.ICiudadService;
import com.prueba.commons.proyecto.models.entity.Ciudad;
import com.prueba.commons.proyecto.models.entity.Departamento;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ciudad/")
public class CiudadController {
    @Autowired
    private ICiudadService ciudadSer;

    @ApiOperation(value = "Retorna lista de Ciudades", notes = "<br>Retorna una lista con todas las Ciudades registradas en la BD"
            , response = Ciudad.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Ciudad> findAll() throws TrainingResourceNoExistsException {
        return ciudadSer.findByAll();

    }

    @ApiOperation(value = "Retorna lista de Ciudades", notes = "<br>Retorna una lista de Ciudades que esten en el departamento solicitado"
            , response = Ciudad.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar/Departamento")
    public List<Ciudad> findByDepartamento(@RequestBody Departamento d) throws TrainingResourceNotFoundException {
        return ciudadSer.findByDepartamento(d);
    }

    @ApiOperation(value = "Retorna una Ciudad", notes = "<br>Retorna una Ciudad atraves del ID"
            , response = Ciudad.class, responseContainer = "Ciudad", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Ciudad finById(@PathVariable Long id) throws TrainingResourceNoExistsException {
        return ciudadSer.findById(id);
    }

    @ApiOperation(value = "Retorna una Ciudad", notes = "<br>Retorna una Ciudad atraves del nombre"
            , response = Ciudad.class, responseContainer = "Ciudad", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/name/{name}")
    public Ciudad findByName(@PathVariable String name) throws TrainingResourceNoExistsException {
        return ciudadSer.findByNameIgnoreCaseContaining(name);
    }

    @ApiOperation(value = "Crea una Ciudad", notes = "<br>Crea una Ciudad recibiendo un objeto Ciudad"
            , response = Ciudad.class, responseContainer = "Ciudad", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad crear(@RequestBody Ciudad a) throws TrainingResourceNoCreateException {
        return ciudadSer.crear(a);
    }

    @ApiOperation(value = "Actualiza la informacion de una Ciudad", notes = "<br>Actualiza la informacion de una Ciudad atraves del ID"
            , response = Ciudad.class, responseContainer = "Ciudad", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad edit(@RequestBody Ciudad a, @PathVariable Long id) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        return ciudadSer.editar(id,a);
    }


    @ApiOperation(value = "Elimina una Ciudad", notes = "<br>Elimina una Ciudad atraves del ID"
            , response = Ciudad.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Ciudad.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        ciudadSer.delete(id);
    }
}
