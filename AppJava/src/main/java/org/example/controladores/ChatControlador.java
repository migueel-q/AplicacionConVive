package org.example.controladores;

import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.modelos.InquilinoPropietario;
import org.example.servicios.ChatServicio;
import org.example.servicios.InquilinoServicio;
import org.example.servicios.InquilinoServicioImpl;
import org.example.servicios.PropietarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatControlador {

    @Autowired
    private ChatServicio chatServicio;
    @Autowired
    private InquilinoServicioImpl inquilinoServicio;
    @Autowired
    private PropietarioServicioImpl propietarioServicio;

    @GetMapping("/{inquilinoId}/{propietarioId}")
    public List<InquilinoPropietario> obtenerChat(
            @PathVariable int inquilinoId,
            @PathVariable int propietarioId
    ) {
        return chatServicio.obtenerChat(inquilinoId, propietarioId);
    }

    @PostMapping("/enviar")
    public InquilinoPropietario enviarMensaje(
            @RequestParam int inquilinoId,
            @RequestParam int propietarioId,
            @RequestParam String mensaje,
            @RequestParam boolean enviadoPorInquilino
    ) {
        Inquilino inq = inquilinoServicio.obtenerInquilinoPorId(inquilinoId);
        Propietario prop = propietarioServicio.obtenerPropietarioPorId(propietarioId);

        return chatServicio.enviarMensaje(inq, prop, mensaje, enviadoPorInquilino);
    }


}

