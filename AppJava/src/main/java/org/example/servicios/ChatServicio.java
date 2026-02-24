package org.example.servicios;

import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.modelos.InquilinoPropietario;
import org.example.repositorios.ChatRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServicio {

    @Autowired
    private ChatRepositorio chatRepositorio;

    public InquilinoPropietario enviarMensaje(Inquilino inq, Propietario prop, String mensaje) {
        InquilinoPropietario msg = new InquilinoPropietario();
        msg.setInquilino(inq);
        msg.setPropietario(prop);
        msg.setFechaMsg(LocalDateTime.now());
        msg.setMensaje(mensaje);

        return chatRepositorio.save(msg);
    }

    public List<InquilinoPropietario> obtenerChat(int idInquilino, int idPropietario) {
        return chatRepositorio.findByInquilinoIdAndPropietarioIdOrderByFechaMsgAsc(idInquilino, idPropietario);
    }
}

