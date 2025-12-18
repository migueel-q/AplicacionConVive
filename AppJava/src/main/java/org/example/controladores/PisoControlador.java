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
@RequestMapping("/pisos")
public class PisoControlador {

    @Autowired
    private final PisoServicioImpl pisoServicio;

    public PisoControlador(PisoServicioImpl pisoServicio) {
        this.pisoServicio = pisoServicio;
    }

    @GetMapping
    public ResponseEntity<List<Piso>> obtenerPisos() {
        List<Piso> pisos = pisoServicio.obtenerPisos();
        if(pisos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(pisos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piso> obtenerPisoPorId(@PathVariable Integer id) {
        Piso piso = pisoServicio.obtenerPisoPorId(id);
        if(piso==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(piso);
    }

    @PostMapping
    public ResponseEntity<Piso> crearPiso(@RequestBody Piso piso) {
        Piso guardado = pisoServicio.guardar(piso);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Piso> actualizarPiso(@PathVariable Integer id, @RequestBody Piso piso) {
        Piso actualizado = pisoServicio.actualizar(piso, id);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPiso(@PathVariable Integer id) {
        Piso eliminado = pisoServicio.eliminar(id);
        if (eliminado != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

