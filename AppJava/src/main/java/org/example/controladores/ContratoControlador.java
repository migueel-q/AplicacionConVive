package org.example.controladores;

import org.example.DTO.ContratoDTO;
import org.example.modelos.Contrato;
import org.example.servicios.ContratoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContratoControlador {

    @Autowired
    private ContratoServicioImpl contratoServicio;

    @GetMapping("/contratos")
    public ResponseEntity<?> obtenerContratos(){
        List<ContratoDTO> contratos = contratoServicio.obtenerContratos();
        if(contratos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/contratos/{id}")
    public ResponseEntity<?> obtenerContratoPorId(@PathVariable int id){
        ContratoDTO contrato = contratoServicio.obtenerContratoPorId(id);
        if(contrato == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrato);
    }

    @PostMapping("/contratos")
    public ResponseEntity<?> nuevoContrato(@RequestBody Contrato contrato){
        Contrato guardado = contratoServicio.guardar(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/contratos/{id}")
    public ResponseEntity<?> editarContrato(@PathVariable Integer id, @RequestBody Contrato contratoEditar){
        Contrato contrato = contratoServicio.actualizar(contratoEditar, id);
        if (contrato == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrato);
    }

    @DeleteMapping("/contratos/{id}")
    public ResponseEntity<?> borrarContrato(@PathVariable Integer id){
        contratoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}