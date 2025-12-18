package org.example.controladores;

import org.example.DAO.GastoDAO;
import org.example.DAO.PisoDAO;
import org.example.modelos.Gasto;
import org.example.modelos.Piso;
import org.example.modelos.Solicitud;
import org.example.servicios.PisoServicio;
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
    private final PisoServicioImpl pisoServicio;

    public PisoControlador(PisoServicioImpl pisoServicio) {
        this.pisoServicio = pisoServicio;
    }

    @GetMapping("/pisos")
    public ResponseEntity<?> obtenerPisos() {
        List<Piso> pisos = pisoServicio.obtenerPisos();
        if(pisos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(pisos);
        }
    }

    @GetMapping("pisos/{id}")
    public ResponseEntity<?> obtenerPisoPorId(@PathVariable Integer id) {
        Piso piso = pisoServicio.obtenerPisoPorId(id);
        if(piso==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(piso);
    }

    @PostMapping("/pisos")
    public ResponseEntity<Piso> nuevoPiso(@RequestBody Piso piso) {
        Piso guardado = pisoServicio.guardar(piso);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/pisos/{id}")
    public ResponseEntity<?> actualizarPiso(@PathVariable Integer id, @RequestBody Piso piso) {
        Piso actualizado = pisoServicio.actualizar(piso, id);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/pisos/{id}")
    public ResponseEntity<?> borrarPiso(@PathVariable Integer id) {
        Piso eliminado = pisoServicio.eliminar(id);
        return ResponseEntity.notFound().build();
    }
}

