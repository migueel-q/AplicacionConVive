package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Piso;
import org.example.modelos.Solicitud;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class PisoDAO implements IDAOGeneral<Piso,Integer> {
    EntityManager em = AccesoBD.getEntityManager();
    @Override
    public void insertar(Piso piso) {
        try {
            em.getTransaction().begin();
            em.persist(piso);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al insertar el Piso");
        } finally {
            em.close();
        }
    }
    @Override
    public void actualizar(Piso piso) {
        try {
            em.getTransaction().begin();
            em.merge(piso);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el Piso");
        } finally {
            em.close();
        }
    }
    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            Piso piso=em.find(Piso.class,id);
            if (piso!=null){
                em.remove(piso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el Piso");
        } finally {
            em.close();
        }
    }
    @Override
    public List<Piso> obtenerTodos() {
        List<Piso> pisos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            pisos = em.createQuery("SELECT p FROM Piso p", Piso.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar los pisos: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return pisos;
    }
    @Override
    public Piso obtenerPorId(Integer id) {
        Piso piso = null;
        try {
            em.getTransaction().begin();
            piso = em.find(Piso.class,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar los pisos: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return piso;
    }

}
