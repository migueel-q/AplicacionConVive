package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Propietario.buscarPorCorreo", query = "select p from Propietario p where p.email=?1")
})
@Entity
@Table(name = "propietarios")
public class Propietario extends Usuario{

    public Propietario() {

    }

   }
