package org.example.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario extends Usuario{

    public Propietario() {

    }

   }
