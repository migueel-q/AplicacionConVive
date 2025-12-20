package org.example.controladores;

import org.example.DTO.InquilinoDTO;
import org.example.modelos.Inquilino;
import org.example.servicios.InquilinoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InquilinoControlador {

    @Autowired
    private InquilinoServicioImpl inquilinoServicio;

    @GetMapping("/inquilinos")
    public ResponseEntity<?> obtenerInquilinos(){
        List<InquilinoDTO> inquilinos = inquilinoServicio.obtenerInquilinos();
        if(inquilinos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquilinos);
    }

    @GetMapping("/inquilinos/{id}")
    public ResponseEntity<?> obtenerInquilinoPorId(@PathVariable Integer id){
        InquilinoDTO inquilino = inquilinoServicio.obtenerInquilinoPorId(id);
        if(inquilino == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquilino);
    }

    @PostMapping("/inquilinos")
    public ResponseEntity<Inquilino> nuevoInquilino(@RequestBody Inquilino inquilino){
        Inquilino guardado= inquilinoServicio.guardar(inquilino);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/inquilinos/{id}")
    public ResponseEntity<?> editarInquilino(@PathVariable Integer id, @RequestBody Inquilino inquilinoEditar){
        Inquilino inquilino = inquilinoServicio.actualizar(inquilinoEditar, id);
        if(inquilino == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquilino);
    }

    @DeleteMapping("/inquilinos/{id}")
    public ResponseEntity<?> borrarInquilino(@PathVariable Integer id){
        inquilinoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
