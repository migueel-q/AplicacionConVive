package org.example.controladores;

import jakarta.servlet.ServletRequest;
import org.example.DTO.OfertaDTO;
import org.example.modelos.Oferta;
import org.example.repositorios.OfertaRepositorio;
import org.example.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OfertaControlador {

    @Autowired
    private OfertaServicio ofertaServicio;
    @Autowired
    private OfertaRepositorio ofertaRepositorio;

    @GetMapping("/ofertas")
    public ResponseEntity<?> obtenerOfertas(){
        List<OfertaDTO> ofertas = ofertaServicio.obtenerOfertas();
        if(ofertas.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ofertas);
        }
    }

    @GetMapping("/ofertas/{id}")
    public ResponseEntity<?> obtenerOfertaPorId(@PathVariable int id){
        Oferta oferta = ofertaServicio.obtenerOfertaPorId(id);
        if(oferta==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oferta);
        }
    }

    @PostMapping("/ofertas")
    public ResponseEntity<?> nuevaOferta(@RequestBody Oferta oferta){
        Oferta guardado=ofertaServicio.guardar(oferta);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/ofertas/{id}")
    public ResponseEntity<?> editarOferta(@PathVariable Integer id, @RequestBody Oferta ofertaEditar){
        Oferta oferta =ofertaServicio.actualizar(ofertaEditar, id);
        if (oferta==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oferta);
        }
    }

    @DeleteMapping("/ofertas/{id}")
    public ResponseEntity<?> eliminarOferta(@PathVariable Integer id){
        ofertaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }




}
