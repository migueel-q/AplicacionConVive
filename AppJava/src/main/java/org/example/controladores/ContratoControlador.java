package org.example.controladores;

import jakarta.servlet.ServletRequest;
import org.example.modelos.Contrato;
import org.example.repositorios.ContratoRepositorio;
import org.example.servicios.ContratoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContratoControlador {

    @Autowired
    private ContratoServicio contratoServicio;
    @Autowired
    private ContratoRepositorio contratoRepositorio;

    @GetMapping("/contratos")
    public ResponseEntity<?> obtenerContratos(){
        List<Contrato> contratos = contratoServicio.obtenerContratos();
        if(contratos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(contratos);
        }
    }

    @GetMapping("/contratos/{id}")
    public ResponseEntity<?> obtenerContratoPorId(@PathVariable int id){
        Contrato contrato = contratoServicio.obtenerContratoPorId(id);
        if(contrato == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(contrato);
        }
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
        }else{
            return ResponseEntity.ok(contrato);
        }
    }

    @DeleteMapping("/contratos/{id}")
    public ResponseEntity<?> eliminarContrato(@PathVariable Integer id){
        contratoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}