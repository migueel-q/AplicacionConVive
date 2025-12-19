package org.example.controladores;

import org.example.modelos.Piso;
import org.example.modelos.Solicitud;
import org.example.servicios.PisoServicioImpl;
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
    private final SolicitudServicioImpl solicitudServicio;

    public SolicitudControlador(SolicitudServicioImpl solicitudServicio) {
        this.solicitudServicio = solicitudServicio;
    }
    @GetMapping("/solicitudes")
    public ResponseEntity<?> obtenerSolicitudes() {
        List<Solicitud> solicitudes = solicitudServicio.obtenerSolicitudes();
        if(solicitudes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(solicitudes);
        }
    }

    @GetMapping("solicitudes/{id}")
    public ResponseEntity<?> obtenerSolicitudPorId(@PathVariable Integer id) {
       Solicitud solicitud = solicitudServicio.obtenerSolicitudPorId(id);
        if(solicitud==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(solicitud);
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud guardado = solicitudServicio.guardar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/solicitudes/{id}")
    public ResponseEntity<?> actualizarSolicitud(@PathVariable Integer id, @RequestBody Solicitud solicitud) {
          Solicitud solicitudActualizads=solicitudServicio.actualizar(solicitud,id);
          return ResponseEntity.ok(solicitudActualizads);
    }

    @DeleteMapping("/solicitudes/{id}")
    public ResponseEntity<?> eliminarSolicitud(@PathVariable Integer id) {
       Solicitud solicitud =solicitudServicio.eliminar(id);
        return ResponseEntity.ok(solicitud);
    }
}
