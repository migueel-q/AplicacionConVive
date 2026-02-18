package org.example.servicios;

import org.example.DTO.ContratoDTO;
import org.example.modelos.Contrato;
import org.example.modelos.Tarea;

import java.util.List;

public interface ContratoServicio {
    List<Contrato> obtenerContratos();
    Contrato obtenerContratoPorId(Integer id);
    Contrato guardar(Contrato contrato);
    Contrato actualizar(Contrato contrato, Integer id);
    Contrato eliminar(Integer id);
}
