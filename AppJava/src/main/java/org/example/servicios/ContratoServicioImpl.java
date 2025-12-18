package org.example.servicios;

import org.example.modelos.Contrato;

import java.util.List;

public class ContratoServicioImpl implements ContratoServicio {
    @Override
    public List<Contrato> obtenerContratos() {
        return List.of();
    }

    @Override
    public Contrato obtenerContratoPorId(Integer id) {
        return null;
    }

    @Override
    public Contrato guardar(Contrato contrato) {
        return null;
    }

    @Override
    public Contrato actualizar(Contrato contrato, Integer id) {
        return null;
    }

    @Override
    public Contrato eliminar(Integer id) {
        return null;
    }
}
