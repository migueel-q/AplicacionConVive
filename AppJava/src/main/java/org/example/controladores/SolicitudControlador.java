package org.example.controladores;

import org.example.DTO.SolicitudDTO;
import org.example.modelos.Solicitud;
import org.example.servicios.SolicitudServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SolicitudControlador {

    @Autowired
    private SolicitudServicioImpl solicitudServicio;

    @GetMapping("/solicitudes")
    public ResponseEntity<?> obtenerSolicitudes() {
        List<SolicitudDTO> solicitudes = solicitudServicio.obtenerSolicitudes();
        if(solicitudes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(solicitudes);
    }

    @GetMapping("solicitudes/{id}")
    public ResponseEntity<?> obtenerSolicitudPorId(@PathVariable Integer id) {
        SolicitudDTO solicitud = solicitudServicio.obtenerSolicitudPorId(id);
        if (solicitud == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(solicitud);
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> nuevoSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud guardado = solicitudServicio.guardar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/solicitudes/{id}")
    public ResponseEntity<?> editarSolicitud(@PathVariable Integer id, @RequestBody Solicitud solicitudEditar) {
          Solicitud solicitud = solicitudServicio.actualizar(solicitudEditar,id);
          if(solicitud == null){
              return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(solicitud);
    }

    @DeleteMapping("/solicitudes/{id}")
    public ResponseEntity<?> borrarSolicitud(@PathVariable Integer id) {
        solicitudServicio.eliminar(id);
        return ResponseEntity.noContent().build();

    }
}
