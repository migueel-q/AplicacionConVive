package org.example.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
    @Column(nullable = false)
    private String calle;
    @Column(nullable = false)
    private String ciudad;
    @Column(nullable = false)
    private String provincia;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, String provincia) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
