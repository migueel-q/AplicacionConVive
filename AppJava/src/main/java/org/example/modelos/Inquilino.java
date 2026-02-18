package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "inquilinos")
public class Inquilino extends Usuario {

    private LocalDateTime fecha_alta;
    @ManyToOne(fetch = FetchType.EAGER)
    private Piso piso;
    @OneToMany(mappedBy = "inquilino",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tarea> tareas;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Oferta> ofertas;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Solicitud> solicitudes;
    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Gasto> gastos;
    @OneToMany(mappedBy = "inquilino", cascade =  CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<InquilinoPropietario> propietarios;     //Esta lista recoge los propietarios con los que hablan los inquilinos y la fecha de los mensajes permiten que se puedan repetir
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
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
        return fecha_alta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fecha_alta = fechaAlta;
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
