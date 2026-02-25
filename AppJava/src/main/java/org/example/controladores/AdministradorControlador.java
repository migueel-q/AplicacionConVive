package org.example.controladores;

import org.example.modelos.Administrador;
import org.example.modelos.Contrato;
import org.example.servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdministradorControlador {
    @Autowired
    private AdministradorServicio administradorServicio;

    @GetMapping("/administradores")
    public ResponseEntity<List<Administrador>> obtenerContratos(){
        List<Administrador> administradores = administradorServicio.obtenerAdministradores();
        if(administradores.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administradores);
    }
}
