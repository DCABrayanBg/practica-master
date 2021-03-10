package com.practica.master.models.service.implement;

import com.practica.master.exception.exceptions.*;
import com.practica.master.models.dao.IContratoDAO;
import com.practica.master.models.service.IContratoService;
import com.prueba.commons.proyecto.models.entity.Area;
import com.prueba.commons.proyecto.models.entity.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService implements IContratoService {

    @Autowired
    private IContratoDAO dao;

    @Autowired
    private Contrato contra;

    @Override
    public List<Contrato> findByAll() throws TrainingResourceNoExistsException {
        if (dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Contrato>) dao.findAll();
    }

    @Override
    public List<Contrato> findByArea(Area area) throws TrainingResourceNotFoundException {
        if(dao.findByArea(area)==null)throw new TrainingResourceNotFoundException();
        return (List<Contrato>) dao.findByArea(area);
    }

    @Override
    public List<Contrato> findByValor_Salario(double salario) throws TrainingResourceNotFoundException {
        if(dao.findByValor_Salario(salario)==null)throw new TrainingResourceNotFoundException();
        return (List<Contrato>) dao.findByValor_Salario(salario);
    }

    @Override
    public Contrato findById(Long id) throws TrainingResourceNoExistsException {
        contra = dao.findById(id).orElse(null);
        if (contra==null) throw new TrainingResourceNoExistsException();
        return contra;
    }

    @Override
    public Contrato findByCodigoIgnoreCaseContaining(String name) throws TrainingResourceNoExistsException {
        contra = dao.findByCodigoIgnoreCaseContaining(name);
        if (contra==null) throw new TrainingResourceNoExistsException();
        return contra;
    }

    @Override
    public Contrato crear(Contrato contrato) throws TrainingResourceNoCreateException {
        try{
            return dao.save(contrato);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Contrato editar(Long id, Contrato contrato) throws TrainingResourceNoExistsException, TrainingResourceNoUpdateException {
        contra=findById(id);
        contra.setArea(contrato.getArea());
        contra.setEps(contrato.getEps());
        contra.setFechaContratacion(contrato.getFechaContratacion());
        contra.setFechaAfiliacionCaja(contrato.getFechaAfiliacionCaja());
        contra.setFechaAfiliacionCesantias(contrato.getFechaAfiliacionCesantias());
        contra.setFechaAfiliacionEps(contrato.getFechaAfiliacionEps());
        contra.setFechaAfiliacionPension(contrato.getFechaAfiliacionPension());
        contra.setFechaTerminacion(contrato.getFechaTerminacion());
        contra.setFechaVencimiento(contrato.getFechaVencimiento());
        contra.setFondoCajaCompensacion(contrato.getFondoCajaCompensacion());
        contra.setFondoCesantias(contrato.getFondoCesantias());
        contra.setFondoPension(contrato.getFondoPension());
        contra.setPorcentaje(contrato.getPorcentaje());
        contra.setValorSalario(contrato.getValorSalario());
        try {
            return dao.save(contra);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceNoExistsException, TrainingResourceDeletedException {
        contra = findById(id);
        try {
            dao.delete(contra);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }
}
