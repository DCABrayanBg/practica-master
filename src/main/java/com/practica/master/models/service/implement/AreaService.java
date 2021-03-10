package com.practica.master.models.service.implement;

import com.practica.master.exception.exceptions.TrainingResourceDeletedException;
import com.practica.master.exception.exceptions.TrainingResourceNoCreateException;
import com.practica.master.exception.exceptions.TrainingResourceNoExistsException;
import com.practica.master.exception.exceptions.TrainingResourceNoUpdateException;
import com.practica.master.models.dao.IAreaDAO;
import com.practica.master.models.service.IAreaService;
import com.prueba.commons.proyecto.models.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {

    @Autowired
    private IAreaDAO dao;

    private Area area;


    @Override
    public List<Area> findByAll() throws TrainingResourceNoExistsException {
        if(dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Area>) dao.findAll();
    }

    @Override
    public List<Area> findByEstado(Boolean estado) throws TrainingResourceNoExistsException {
        if (dao.findByEstado(estado)==null) throw new TrainingResourceNoExistsException();
        return (List<Area>) dao.findByEstado(estado);
    }

    @Override
    public Area findById(Long id) throws TrainingResourceNoExistsException {
        area = dao.findById(id).orElse(null);
        if(area == null) throw new TrainingResourceNoExistsException();
        return area;
    }

    @Override
    public Area crear(Area area) throws TrainingResourceNoCreateException {
        try {
            return dao.save(area);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Area editar(Long id, Area area) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        this.area = findById(id);
        this.area.setEstado(area.getEstado());
        this.area.setDescripcion(area.getDescripcion());
        this.area.setDiasVacaciones(area.getDiasVacaciones());
        this.area.setCuentaNominaPorPagar(area.getCuentaNominaPorPagar());
        this.area.setPrefijoContable(area.getPrefijoContable());

        try{
            return dao.save(area);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        area = findById(id);
        try{
            dao.delete(area);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }

    @Override
    public Area estado(Long id, Boolean estado) throws TrainingResourceNoExistsException {
        area = findById(id);
        area.setEstado(estado);
        return dao.save(area);
    }
}
