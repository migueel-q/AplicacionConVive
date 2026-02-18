package org.example.servicios;

import org.example.DTO.GastoDTO;
import org.example.modelos.Gasto;

import java.util.List;

public interface GastoServicio {
    List<Gasto> obtenerGastos();
    Gasto obtenerGastoPorId(Integer id);
    Gasto guardar(Gasto gasto);
    Gasto modificar(Gasto gasto,Integer id);
    Gasto eliminar(Integer id);
}
