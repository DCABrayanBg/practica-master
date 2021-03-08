package com.practica.master.controller;

import com.practica.master.models.service.IAreaService;
import com.prueba.commons.proyecto.models.entity.Area;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area/")
public class AreaController {

    @Autowired
    private IAreaService areaSer;

    @ApiOperation(value = "Retorna lista de Areas", notes = "<br>Retorna una lista con todas las Area registradas en la BD"
            , response = Area.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Area> findAll()  {
        return areaSer.findByAll();

    }

    @ApiOperation(value = "Retorna lista de Areas", notes = "<br>Retorna una lista con de Areas que tengan el esatdo solicitado"
            , response = Area.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar/estado/{estado}")
    public List<Area> findByEstado(@PathVariable boolean estado)  {
        return areaSer.findByEstado(estado);
    }

    @ApiOperation(value = "Retorna una Area", notes = "<br>Retorna una Area atraves del ID"
            , response = Area.class, responseContainer = "Area", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Area finById(@PathVariable Long id) {
        return areaSer.findById(id);
    }

    @ApiOperation(value = "Crea una Area", notes = "<br>Crea una Area recibiendo un objeto Area"
            , response = Area.class, responseContainer = "Area", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Area crear(@RequestBody Area a) {
        return areaSer.crear(a);
    }

    @ApiOperation(value = "Actualiza la informacion de una Area", notes = "<br>Actualiza la informacion de una Area atraves del ID"
            , response = Area.class, responseContainer = "Area", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Area edit(@RequestBody Area a, @PathVariable Long id) {
        return areaSer.editar(id,a);
    }


    @ApiOperation(value = "Elimina una Area", notes = "<br>Elimina una Area atraves del ID"
            , response = Area.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        areaSer.delete(id);
    }

    @ApiOperation(value = "Modifica el estado del Area", notes = "<br>Modifica el esrado de un Area atraves del ID"
            , response = Area.class, responseContainer = "Area", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Area.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/estado/{estado}")
    public Area estado(@PathVariable Long id, @PathVariable Boolean estado) {
        return areaSer.estado(id,estado);
    }

}