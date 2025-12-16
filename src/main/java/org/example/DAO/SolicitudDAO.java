package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Piso;
import org.example.modelos.Solicitud;
import org.example.persistencia.AccesoBD;

public class SolicitudDAO {
    EntityManager em = AccesoBD.getEntityManager();
    public void insertarSolicitud(Solicitud solicitud) {
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
    public void eliminarSolicitud(int id) {
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
    public void actualizarSolicitud(Solicitud solicitud) {
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
    public void listarSolicitudes() {
        try {
            em.getTransaction().begin();
            TypedQuery<Solicitud> query = em.createQuery("Select s from Solicitud s", Solicitud.class);
            var solicitudes=query.getResultList();
            solicitudes.forEach(s->{
                System.out.println("Inquilino"+s.getInquilino());
                System.out.println("Oferta "+s.getOferta());
                System.out.println("Esta aceptada (Si o No)"+s.isAceptado());
            });

        } catch (Exception e) {
            System.out.println("Error al buscar la solicitud");
        } finally {
            em.close();
        }
    }
    public void listarSolicitud(int id) {
        try {
            em.getTransaction().begin();
            Solicitud solicitud = em.find(Solicitud.class, id);
            System.out.println(solicitud.toString());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al buscar la solicitud por id");
        } finally {
            em.close();
        }
    }
    }

