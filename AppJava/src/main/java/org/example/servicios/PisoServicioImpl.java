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
    public List<PisoDTO> obtenerPisos() {

        return pisoRepositorio.findAll().stream().map(p ->
                        new PisoDTO( p.getId(),
                                p.getDireccion(),
                                p.getDescripcion(),
                                p.getUrl_imagen(),
                                p.isDisponible(),
                                p.getOfertas(),
                                p.getGastos(),
                                p.getContratos()))
                .toList();
    }

    @Override
    public PisoDTO obtenerPisoPorId(Integer id) {
        return pisoRepositorio.findById(id).map(p ->
                        new PisoDTO(p.getId(),
                                p.getDireccion(),
                                p.getDescripcion(),
                                p.getUrl_imagen(),
                                p.isDisponible(),
                                p.getOfertas(),
                                p.getGastos(),
                                p.getContratos()))
                .orElse(null);
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
            existe.setPropietario(existe.getPropietario());
            existe.setInquilinos(existe.getInquilinos());
            existe.setGastos(existe.getGastos());
            existe.setOfertas(existe.getOfertas());
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
