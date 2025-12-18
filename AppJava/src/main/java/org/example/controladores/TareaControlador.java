package org.example.controladores;

import org.example.modelos.Gasto;
import org.example.modelos.Tarea;
import org.example.servicios.TareaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TareaControlador {
    @Autowired
    private TareaServicioImpl tareaServicio;

    @GetMapping("/tareas")
    public ResponseEntity<?> obtenerGastos(){
        List<Tarea> gastos = tareaServicio.obtenerTareas();
        if(gastos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("tareas/{id}")
    public ResponseEntity<?> obtenerGastoPorId(@PathVariable Integer id) {
        Tarea tarea = tareaServicio.obtenerTareaPorId(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    @PostMapping("/tareas")
    public ResponseEntity<Tarea> nuevoGasto(@RequestBody Tarea tareaNueva){
        Tarea tareaGuardada = tareaServicio.guardar(tareaNueva);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaGuardada);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity<?> editarGasto(@RequestBody Tarea tareaEditar, @PathVariable Integer id){
        Tarea tarea = tareaServicio.actualizar(tareaEditar, id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> borrarGasto(@PathVariable Integer id){
        tareaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
