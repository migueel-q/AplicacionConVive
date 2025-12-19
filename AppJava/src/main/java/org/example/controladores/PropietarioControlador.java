package org.example.controladores;

import org.example.DTO.PropietarioDTO;
import org.example.modelos.Propietario;
import org.example.servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropietarioControlador {
    @Autowired
    private PropietarioServicio propietarioServicio;

    @GetMapping("/propietarios")
    public ResponseEntity<?> obtenerPropietarios(){
        List<PropietarioDTO> propietarios = propietarioServicio.obtenerPropietarios();
        if(propietarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(propietarios);
        }
    }

    @GetMapping("/propietarios/{id}")
    public ResponseEntity<Propietario> obtenerPropietarioPorId(@PathVariable Integer id){
        Propietario propietario = propietarioServicio.obtenerPropietarioPorId(id);
        if(propietario == null){
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(propietario);
        }
    }

    @PostMapping("/propietarios")
    public ResponseEntity<Propietario> nuevoPropietario(@RequestBody Propietario propietario){
        Propietario guardado=propietarioServicio.guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/propietarios/{id}")
    public ResponseEntity<?> editarPropietario(@PathVariable Integer id, @RequestBody Propietario propietarioEditar){
        Propietario propietario = propietarioServicio.actualizar(propietarioEditar, id);
        if(propietario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(propietario);
    }

    @DeleteMapping("/propietarios/{id}")
    public ResponseEntity<?> borrarPropietario(@PathVariable Integer id){
            propietarioServicio.eliminar(id);
            return ResponseEntity.noContent().build();
    }
}
