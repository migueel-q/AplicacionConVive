package org.example.controladores;

import org.example.DAO.GastoDAO;
import org.example.modelos.Gasto;
import org.example.servicios.GastoServicio;
import org.example.servicios.GastoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GastoControlador {
    @Autowired
    private GastoServicioImpl gastoServicio;

    @GetMapping("/gastos")
    public ResponseEntity<?> obtenerGastos(){
        List<Gasto> gastos = gastoServicio.obtenerGastos();
        if(gastos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("gastos/{id}")
    public ResponseEntity<?> obtenerGastoPorId(@PathVariable Integer id) {
        Gasto gasto = gastoServicio.obtenerGastoPorId(id);
        if (gasto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gasto);
    }

    @PostMapping("/gastos")
    public ResponseEntity<Gasto> nuevoGasto(@RequestBody Gasto gastoNuevo){
        Gasto gastoGuardado = gastoServicio.guardar(gastoNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(gastoGuardado);
    }

    @PutMapping("/gastos/{id}")
    public ResponseEntity<?> editarGasto(@RequestBody Gasto gastoEditar, @PathVariable Integer id){
        Gasto gasto = gastoServicio.modificar(gastoEditar, id);
        if (gasto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gasto);
    }

    @DeleteMapping("/gastos/{id}")
    public ResponseEntity<?> borrarGasto(@PathVariable Integer id){
        gastoServicio.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
