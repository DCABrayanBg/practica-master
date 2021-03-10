package com.practica.master.controller;

import com.practica.master.exception.exceptions.TrainingResourceNoCreateException;
import com.practica.master.exception.exceptions.TrainingResourceNoExistsException;
import com.practica.master.exception.exceptions.TrainingResourceNoUpdateException;
import com.practica.master.exception.exceptions.TrainingResourceNotFoundException;
import com.practica.master.models.service.IDepartamentoService;
import com.prueba.commons.proyecto.models.entity.Departamento;
import com.prueba.commons.proyecto.models.entity.Pais;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departamento/")
public class DepartamentoController {
    @Autowired
    private IDepartamentoService departamentoSer;

    @ApiOperation(value = "Retorna lista de Departamentos", notes = "<br>Retorna una lista con todos los Departamento registrados en la BD"
            , response = Departamento.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Departamento> findAll() throws TrainingResourceNotFoundException {
        return departamentoSer.findByAll();

    }

    @ApiOperation(value = "Retorna lista de Departamentos", notes = "<br>Retorna una lista de Departamentos que esten en el Pais solicitado"
            , response = Departamento.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar/Pais")
    public List<Departamento> findByPais(@RequestBody Pais p) throws TrainingResourceNotFoundException {
        return departamentoSer.findByPais(p);
    }

    @ApiOperation(value = "Retorna un Departamento", notes = "<br>Retorna un Departamento atraves del ID"
            , response = Departamento.class, responseContainer = "Departamento", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Departamento finById(@PathVariable Long id) throws TrainingResourceNoExistsException {
        return departamentoSer.findById(id);
    }

    @ApiOperation(value = "Retorna un Departamento", notes = "<br>MRetorna un Departamento atraves del nombre"
            , response = Departamento.class, responseContainer = "Departamento", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/name/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Departamento findByName(@PathVariable String name) throws TrainingResourceNoExistsException {
        return departamentoSer.findByNameIgnoreCaseContaining(name);
    }

    @ApiOperation(value = "Crea una Departamento", notes = "<br>Crea una Departamento recibiendo un objeto Departamento"
            , response = Departamento.class, responseContainer = "Departamento", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento crear(@RequestBody Departamento a) throws TrainingResourceNoCreateException {
        return departamentoSer.crear(a);
    }

    @ApiOperation(value = "Actualiza la informacion de un Departamento", notes = "<br>Actualiza la informacion de un Departamento atraves del ID"
            , response = Departamento.class, responseContainer = "Departamento", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento edit(@RequestBody Departamento a, @PathVariable Long id) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        return departamentoSer.editar(id,a);
    }


    @ApiOperation(value = "Elimina un Departamento", notes = "<br>Elimina un Departamento atraves del ID"
            , response = Departamento.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Departamento.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceNoExistsException {
        departamentoSer.delete(id);
    }
}
