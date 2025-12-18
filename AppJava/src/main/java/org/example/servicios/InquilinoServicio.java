package org.example.servicios;

import org.example.modelos.Inquilino;

import java.util.List;

public interface InquilinoServicio {
    List<Inquilino> obtenerInquilinos();
    Inquilino obtenerInquilinoPorId(Integer id);
    public Inquilino guardar(Inquilino inquilino);
    public Inquilino actualizar(Inquilino inquilino, Integer id);
    public Inquilino eliminar(Integer id);
}
