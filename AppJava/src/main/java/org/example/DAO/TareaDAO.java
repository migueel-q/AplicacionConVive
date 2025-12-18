package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.modelos.Gasto;
import org.example.modelos.Tarea;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class TareaDAO implements IDAOGeneral<Tarea, Integer> {
    @Override
    public void insertar(Tarea tarea) {
        EntityManager em = AccesoBD.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(tarea);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error al insertar la tarea: "+e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }

    @Override
    public void actualizar(Tarea tarea) {
        EntityManager em = AccesoBD.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(tarea);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error al modificar la tarea: "+e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        EntityManager em = AccesoBD.getEntityManager();
        try{
            em.getTransaction().begin();
            Tarea tareaEliminar = em.find(Tarea.class, id);
            em.remove(tareaEliminar);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error al eliminar la tarea: "+e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }

    @Override
    public List<Tarea> obtenerTodos() {
        EntityManager em = AccesoBD.getEntityManager();
        List<Tarea> tareas = new ArrayList<>();
        try {
            em.getTransaction().begin();
            tareas = em.createQuery("SELECT t FROM Tarea t", Tarea.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar las tareas: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return tareas;
    }

    @Override
    public Tarea obtenerPorId(Integer id) {
        EntityManager em = AccesoBD.getEntityManager();
        Tarea tareaBuscar = null;
        try {
            em.getTransaction().begin();
            tareaBuscar = em.find(Tarea.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar los gastos: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return tareaBuscar;
    }
}
