package org.example.servicios;

import org.example.DTO.PisoDTO;
import org.example.modelos.Piso;
import org.example.repositorios.PisoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PisoServicioImpl implements  PisoServicio {
    @Autowired
    private PisoRepositorio pisoRepositorio;
    @Override
    public List<Piso> obtenerPisos() {

        return pisoRepositorio.findAll();
    }

    @Override
    public Piso obtenerPisoPorId(Integer id) {
        return pisoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Piso guardar(Piso piso) {
        return pisoRepositorio.save(piso);
    }

    @Override
    public Piso actualizar(Piso piso, Integer id) {
        Piso existe = pisoRepositorio.findById(id).orElse(null);
        if (existe!=null){
            existe.setDescripcion(piso.getDescripcion());
            existe.setDireccion(existe.getDireccion());
            existe.setDisponible(existe.isDisponible());
            return pisoRepositorio.save(existe);
        }
        return null;
    }

    @Override
    public Piso eliminar(Integer id) {
        Piso existe = pisoRepositorio.findById(id).orElse(null);
        if (existe!=null){
            pisoRepositorio.delete(existe);
        }
        return existe;
    }
}
