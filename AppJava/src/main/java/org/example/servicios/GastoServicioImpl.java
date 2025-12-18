package org.example.servicios;

import org.example.modelos.Gasto;

import java.util.List;

public class GastoServicioImpl implements GastoServicio {
    @Override
    public List<Gasto> obtenerTodos() {
        return List.of();
    }

    @Override
    public Gasto findById(Integer id) {
        return null;
    }

    @Override
    public Gasto guardar(Gasto gasto) {
        return null;
    }

    @Override
    public Gasto modificar(Gasto gasto, Integer id) {
        return null;
    }

    @Override
    public void borrar(Integer id) {

    }
}
