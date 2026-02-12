package org.example.servicios;

import org.example.DTO.InquilinoDTO;
import org.example.modelos.Inquilino;
import org.example.repositorios.InquilinoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquilinoServicioImpl implements InquilinoServicio {
    @Autowired
    private InquilinoRepositorio inquilinoRepositorio;

    @Override
    public List<Inquilino> obtenerInquilinos() {
        return inquilinoRepositorio.findAll();
    }

    @Override
    public Inquilino obtenerInquilinoPorId(Integer id) {
        return inquilinoRepositorio.findById(id).orElse(null);
    }


    @Override
    public Inquilino guardar(Inquilino inquilino) {
        return inquilinoRepositorio.save(inquilino);
    }

    @Override
    public Inquilino actualizar(Inquilino inquilinoEditar, Integer id) {
        Inquilino inquilino = inquilinoRepositorio.findById(id).orElse(null);
        if (inquilino != null) {
            inquilino.setContrato(inquilinoEditar.getContrato());
            inquilino.setOfertas(inquilinoEditar.getOfertas());
            inquilino.setPiso(inquilinoEditar.getPiso());
            inquilino.setPropietarios(inquilinoEditar.getPropietarios());
            inquilino.setGastos(inquilinoEditar.getGastos());
            inquilino.setFechaAlta(inquilinoEditar.getFechaAlta());
            inquilino.setSolicitudes(inquilinoEditar.getSolicitudes());
            inquilino.setTareas(inquilinoEditar.getTareas());
            inquilino.setEmail(inquilinoEditar.getEmail());
            inquilino.setNombre_real(inquilinoEditar.getNombre_real());
            inquilino.setNombre_usuario(inquilinoEditar.getNombre_usuario());
            inquilino.setPassword(inquilinoEditar.getPassword());
            inquilino.setFecha_nacimiento(inquilinoEditar.getFecha_nacimiento());
            inquilinoRepositorio.save(inquilino);
        }
        return inquilino;
    }

    @Override
    public Inquilino eliminar(Integer id) {
        if(inquilinoRepositorio.existsById(id))
        {
            Inquilino inquilino = inquilinoRepositorio.findById(id).get();
            inquilinoRepositorio.delete(inquilino);
            return inquilino;
        }
        else
        {
            return null;
        }
    }
}
