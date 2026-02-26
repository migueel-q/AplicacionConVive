package org.example.servicios;

import org.example.DTO.PisoDTO;
import org.example.modelos.Inquilino;
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
            existe.setDireccion(piso.getDireccion());
            existe.setDisponible(piso.isDisponible());
            existe.setPrecio(piso.getPrecio());
            existe.setValidado(piso.isValidado());
            existe.setUrl_imagen(piso.getUrl_imagen());
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

    public List<Inquilino> obtenerInquilinosDePropietario(int propietarioId) {
        return pisoRepositorio.findInquilinosByPropietarioId(propietarioId);
    }

}
