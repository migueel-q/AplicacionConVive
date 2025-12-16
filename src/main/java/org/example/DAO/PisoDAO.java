package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Piso;
import org.example.persistencia.AccesoBD;

public class PisoDAO {
    EntityManager em = AccesoBD.getEntityManager();
    public void insertarPiso(Piso piso) {
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
    public void actualizarPiso(Piso piso) {
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
    public void eliminarPiso(int id) {
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
    public void buscarPisos() {
        try {
            em.getTransaction().begin();
            TypedQuery<Piso>  query = em.createQuery("Select p from Piso p", Piso.class);
            var pisos=query.getResultList();
            pisos.forEach(p->{
                System.out.println("direccion"+p.getDireccion());
                System.out.println("descripcion"+p.getDescripcion());
                System.out.println("Disponible (Si o No)"+p.isDisponible());
                System.out.println("Inquilinos"+p.getInquilinos());
                System.out.println("Propietario"+p.getPropietario());
            });
        } catch (Exception e) {
            System.out.println("Error al buscar los pisos");
        } finally {
            em.close();
        }
    }
    public void buscarPiso(int id) {
        try {
            em.getTransaction().begin();
            Piso piso = em.find(Piso.class, id);
            System.out.println(piso.toString());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al buscar el Piso");
        }
    }
}
