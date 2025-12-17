package org.example.persistencia;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AccesoBD {
    public static EntityManager getEntityManager(){
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("miUnidadDePersistencia").createEntityManager();
            
        } catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return em;
    }
}
