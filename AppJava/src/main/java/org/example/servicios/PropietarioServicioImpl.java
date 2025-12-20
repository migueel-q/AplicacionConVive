package org.example.servicios;

import org.example.DTO.PropietarioDTO;
import org.example.modelos.Propietario;
import org.example.repositorios.PropietarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServicioImpl implements PropietarioServicio {
    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    @Override
    public List<PropietarioDTO> obtenerPropietarios() {
        return propietarioRepositorio.findAll().stream().map(p ->
                        new PropietarioDTO( p.getId(),
                                p.getNombre_usuario(),
                                p.getNombre_real(),
                                p.getFecha_nacimiento(),
                                p.getEmail(),
                                p.getPisos(),
                                p.getInquilinos(),
                                p.getOfertas(),
                                p.getContratos()))
                .toList();
    }

    @Override
    public PropietarioDTO obtenerPropietarioPorId(Integer id) {
        return propietarioRepositorio.findById(id).map(p ->
                        new PropietarioDTO( p.getId(),
                                p.getNombre_usuario(),
                                p.getNombre_real(),
                                p.getFecha_nacimiento(),
                                p.getEmail(),
                                p.getPisos(),
                                p.getInquilinos(),
                                p.getOfertas(),
                                p.getContratos()))
                .orElse(null);
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepositorio.save(propietario);
    }

    @Override
    public Propietario actualizar(Propietario propietarioEditar, Integer id) {
        Propietario propietario = propietarioRepositorio.findById(id).orElse(null);
        if (propietario != null) {
            propietario.setContratos(propietarioEditar.getContratos());
            propietario.setInquilinos(propietarioEditar.getInquilinos());
            propietario.setOfertas(propietarioEditar.getOfertas());
            propietario.setPisos(propietarioEditar.getPisos());
            propietario.setEmail(propietarioEditar.getEmail());
            propietario.setFecha_nacimiento(propietarioEditar.getFecha_nacimiento());
            propietario.setNombre_real(propietarioEditar.getNombre_real());
            propietario.setNombre_usuario(propietarioEditar.getNombre_usuario());
            propietario.setPassword(propietarioEditar.getPassword());
            propietarioRepositorio.save(propietario);
        }
        return propietario;
    }


    @Override
    public Propietario eliminar(Integer id) {
        if(propietarioRepositorio.existsById(id))
        {
            Propietario propietario = propietarioRepositorio.findById(id).get();
            propietarioRepositorio.delete(propietario);
            return propietario;
        }
        else
        {
            return null;
        }
    }
}
