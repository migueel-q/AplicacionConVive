package org.example.servicios;

import org.example.modelos.Gasto;

import java.util.List;

public interface GastoServicio {
    public List<Gasto> obtenerTodos();
    public Gasto findById(Integer id);
    public Gasto guardar(Gasto gasto);
    public Gasto modificar(Gasto gasto,Integer id);
    public void borrar(Integer id);
}
