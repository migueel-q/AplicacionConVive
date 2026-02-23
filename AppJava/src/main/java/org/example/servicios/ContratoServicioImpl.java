package org.example.servicios;

import org.example.DTO.ContratoDTO;
import org.example.modelos.Contrato;
import org.example.repositorios.ContratoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratoServicioImpl implements ContratoServicio {

    @Autowired
    private ContratoRepositorio contratoRepositorio;

    @Override
    public List<Contrato> obtenerContratos() {
        return contratoRepositorio.findAll();
    }

    @Override
    public Contrato obtenerContratoPorId(Integer id) {
        return contratoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Contrato guardar(Contrato contrato) {
        return contratoRepositorio.save(contrato);
    }

    @Override
    public Contrato actualizar(Contrato contratoActualizar, Integer id) {
        Contrato contrato = contratoRepositorio.findById(id).orElse(null);

        if (contrato != null) {
            contrato.setDescripcion(contratoActualizar.getDescripcion());
            contrato.setPrecio(contratoActualizar.getPrecio());
            contrato.setFecha_inicio(contratoActualizar.getFecha_inicio());
            contrato.setFecha_fin(contratoActualizar.getFecha_fin());
            contrato.setPiso(contratoActualizar.getPiso());

            contratoRepositorio.save(contrato);
        }

        return contrato;
    }

    @Override
    public Contrato eliminar(Integer id) {
        if (contratoRepositorio.existsById(id)) {
            Contrato contrato = contratoRepositorio.findById(id).get();
            contratoRepositorio.delete(contrato);
            return contrato;
        } else {
            return null;
        }
    }
}