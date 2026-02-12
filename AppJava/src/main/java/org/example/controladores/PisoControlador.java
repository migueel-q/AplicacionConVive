package org.example.controladores;

import org.example.DTO.PisoDTO;
import org.example.modelos.Piso;
import org.example.servicios.PisoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PisoControlador {

    @Autowired
    private PisoServicioImpl pisoServicio;

    @GetMapping("/pisos")
    public ResponseEntity<List<Piso>> obtenerPisos() {
        List<Piso> pisos = pisoServicio.obtenerPisos();
        if(pisos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pisos);
    }

    @GetMapping("pisos/{id}")
    public ResponseEntity<Piso> obtenerPisoPorId(@PathVariable Integer id) {
        Piso piso = pisoServicio.obtenerPisoPorId(id);
        if (piso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(piso);
    }

    @PostMapping("/pisos")
    public ResponseEntity<Piso> nuevoPiso(@RequestBody Piso piso) {
        Piso guardado = pisoServicio.guardar(piso);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/pisos/{id}")
    public ResponseEntity<Piso> actualizarPiso(@PathVariable Integer id, @RequestBody Piso pisoEditar) {
        Piso piso = pisoServicio.actualizar(pisoEditar, id);
        if (piso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(piso);

    }


    @DeleteMapping("/pisos/{id}")
    public ResponseEntity<Piso> borrarPiso(@PathVariable Integer id) {
        pisoServicio.eliminar(id);
        return ResponseEntity.notFound().build();
    }
}

