package org.example.servicios;

import org.example.modelos.Contrato;
import org.example.modelos.Tarea;

import java.util.List;

public interface ContratoServicio {
    List<Contrato> obtenerContratos();
    Contrato obtenerContratoPorId(Integer id);
    public Contrato guardar(Contrato contrato);
    public Contrato actualizar(Contrato contrato, Integer id);
    public Contrato eliminar(Integer id);
}
