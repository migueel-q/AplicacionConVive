package org.example.servicios;

import org.example.modelos.Administrador;
import org.example.repositorios.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Override
    public List<Administrador> obtenerAdministradores() {
        return administradorRepositorio.findAll();
    }
}
