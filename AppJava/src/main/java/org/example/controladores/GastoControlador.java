package org.example.controladores;

import org.example.DAO.GastoDAO;
import org.example.modelos.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoControlador {

    @Autowired
    private GastoDAO gastoDAO;

    @GetMapping
    public List<Gasto> obtenerGastos(){
        return gastoDAO.obtenerTodos();
    }
}
