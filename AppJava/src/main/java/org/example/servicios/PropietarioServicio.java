package org.example.servicios;

import org.example.modelos.Propietario;

import java.util.List;

public interface PropietarioServicio {
    public List<Propietario> obtenerPropietarios();
    public Propietario obtenerPropietarioPorId(Integer id);
    public Propietario guardar(Propietario propietario);
    public Propietario actualizar(Propietario propietario, Integer id);
    public Propietario eliminar(Integer id);
}
