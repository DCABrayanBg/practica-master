package com.practica.master.controller;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.service.IContratoService;
import com.prueba.commons.proyecto.models.entity.Area;
import com.prueba.commons.proyecto.models.entity.Contrato;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contrato/")
public class ContratoController {

    @Autowired
    private IContratoService contratoSer;


    @ApiOperation(value = "Retorna lista de Contratos", notes = "<br>Retorna una lista con todos los Contratos registrados en la BD"
            , response = Contrato.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Contrato> findByAll() throws TrainingResourceNoExistsException {
        return contratoSer.findByAll();
    }


    @ApiOperation(value = "Retorna lista de Contratos", notes = "<br>Retorna una lista con los Contratos que designados al area solicitada"
            , response = Contrato.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar/area/{area}")
    public List<Contrato> findByArea(Area area) throws TrainingResourceNotFoundException {
        return contratoSer.findByArea(area);
    }


    @ApiOperation(value = "Retorna lista de Contratos", notes = "<br>Retorna una lista con los Contratos que tengan el valor de salario solicitado"
            , response = Contrato.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar/salario/{area}")
    public List<Contrato> findByValor_Salario(Double salario) throws TrainingResourceNotFoundException {
        return contratoSer.findByValor_Salario(salario);
    }


    @ApiOperation(value = "Retorna un Contrato", notes = "<br>Retorna un Contrato atraves del ID"
            , response = Contrato.class, responseContainer = "Contrato", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Contrato findById(Long id) throws TrainingResourceNoExistsException {
        return contratoSer.findById(id);
    }


    @ApiOperation(value = "Retorna un Contrato", notes = "<br>Retorna un Contrato atraves del codigo"
            , response = Contrato.class, responseContainer = "Contrato", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/cod/{codigo}")
    public Contrato findByCodigoIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException {
        return contratoSer.findByCodigoIgnoreCaseContaining(name);
    }


    @ApiOperation(value = "Crea un Contrato", notes = "<br>Crea un Contrato recibiendo un objeto Contrato"
            , response = Contrato.class, responseContainer = "Contrato", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Contrato crear(Contrato contrato) throws TrainingResourceNoCreateException {
        return contratoSer.crear(contrato);
    }


    @ApiOperation(value = "Actualiza la informacion de un Contrato", notes = "<br>Actualiza la informacion de un Contrato atraves del ID"
            , response = Contrato.class, responseContainer = "Contrato", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Contrato editar(Long id, Contrato contrato) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        return contratoSer.editar(id, contrato);
    }


    @ApiOperation(value = "Elimina un Contrato", notes = "<br>Elimina un Contrato atraves del ID"
            , response = Contrato.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Contrato.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        contratoSer.delete(id);
    }
}
