package org.example.controladores;

import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.modelos.InquilinoPropietario;
import org.example.servicios.ChatServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatControlador {

    @Autowired
    private ChatServicio chatServicio;

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
            @RequestParam String mensaje
    ) {
        Inquilino inq = new Inquilino();
        inq.setId(inquilinoId);

        Propietario prop = new Propietario();
        prop.setId(propietarioId);

        return chatServicio.enviarMensaje(inq, prop, mensaje);
    }
}

