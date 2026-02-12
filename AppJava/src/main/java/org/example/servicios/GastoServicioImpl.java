package org.example.servicios;

import org.example.DTO.GastoDTO;
import org.example.modelos.Gasto;
import org.example.repositorios.GastoRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GastoServicioImpl implements GastoServicio {
    @Autowired
    private GastoRespositorio gastoRespositorio;
    @Override
    public List<Gasto> obtenerGastos() {
        return gastoRespositorio.findAll();
    }

    @Override
    public Gasto obtenerGastoPorId(Integer id) {
        return gastoRespositorio.findById(id).orElse(null);
    }

    @Override
    public Gasto guardar(Gasto gasto) {
        return gastoRespositorio.save(gasto);
    }

    @Override
    public Gasto modificar(Gasto gastoEditar, Integer id) {
        Gasto gasto = gastoRespositorio.findById(id).orElse(null);
        if (gasto != null) {
            gasto.setValor(gastoEditar.getValor());
            gasto.setPiso(gastoEditar.getPiso());
            gasto.setConcepto(gastoEditar.getConcepto());
            gasto.setInquilino(gastoEditar.getInquilino());
            gastoRespositorio.save(gasto);
        }
        return gasto;
    }

    @Override
    public Gasto eliminar(Integer id) {
        if (gastoRespositorio.existsById(id)) {
            Gasto gasto = gastoRespositorio.findById(id).get();
            gastoRespositorio.delete(gasto);
            return gasto;
        } else {
            return null;
        }
    }
}
