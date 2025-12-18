package org.example.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "inquilinos")
public class Inquilino extends Usuario {

    private LocalDateTime fechaAlta;
    @ManyToOne
    private Piso piso;
    @OneToMany(mappedBy = "inquilino",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> ofertas;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud> solicitudes;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gasto> gastos;
    @OneToMany(mappedBy = "inquilino", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<InquilinoPropietario> propietarios;     //Esta lista recoge los propietarios con los que hablan los inquilinos y la fecha de los mensajes permiten que se puedan repetir
    @ManyToOne
    private Contrato contrato;

    public Inquilino() {
    }

    public List<InquilinoPropietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<InquilinoPropietario> propietarios) {
        this.propietarios = propietarios;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "nombreUsuario='" + nombre_usuario + '\'' +
                ", nombreReal='" + nombre_real + '\'' +
                ", fechaNacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                ", piso=" + piso +
                '}';
    }
}
