package org.example.servicios;

import org.example.DTO.GastoDTO;
import org.example.modelos.Gasto;

import java.util.List;

public interface GastoServicio {
    public List<GastoDTO> obtenerGastos();
    public Gasto obtenerGastoPorId(Integer id);
    public Gasto guardar(Gasto gasto);
    public Gasto modificar(Gasto gasto,Integer id);
    public Gasto borrar(Integer id);
}
