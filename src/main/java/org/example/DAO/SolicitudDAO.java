package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.modelos.Solicitud;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO implements IDAOGeneral<Solicitud, Integer> {
    EntityManager em = AccesoBD.getEntityManager();
    @Override
    public void insertar(Solicitud solicitud) {
        try {
            em.getTransaction().begin();
            em.persist(solicitud);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al insertar solicitud");
        } finally {
            em.close();
        }
    }
    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            Solicitud solicitud = em.find(Solicitud.class, id);
            if (solicitud != null) {
                em.remove(solicitud);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar solicitud");
        } finally {
            em.close();
        }
    }
    @Override
    public void actualizar(Solicitud solicitud) {
        try {
            em.getTransaction().begin();
            em.merge(solicitud);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar solicitud");
        } finally {
            em.close();
        }
    }
    @Override
    public List<Solicitud> obtenerTodos() {
        List<Solicitud> solicitudes = new ArrayList<>();
        try {
            em.getTransaction().begin();
           solicitudes = em.createQuery("SELECT s FROM Solicitud s", Solicitud.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar las solicitudes: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return solicitudes;
    }
    @Override
    public Solicitud obtenerPorId(Integer id) {
        Solicitud solicitud = null;
        try {
            em.getTransaction().begin();
            solicitud = em.find(Solicitud.class,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar las solicitudes: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return solicitud;
    }
}

