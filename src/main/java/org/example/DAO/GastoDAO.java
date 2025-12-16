package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.modelos.Gasto;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class GastoDAO implements IDAOGeneral<Gasto, Integer> {
    EntityManager em = AccesoBD.getEntityManager();
    @Override
    public void insertar(Gasto gasto) {
        try{
            em.getTransaction().begin();
            em.persist(gasto);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error al insertar el gasto: "+e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }

    @Override
    public void actualizar(Gasto gasto) {
        try{
            em.getTransaction().begin();
            em.merge(gasto);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error al modificar el gasto: "+e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try{
            em.getTransaction().begin();
            Gasto gastoEliminar = em.find(Gasto.class,id);
            em.remove(gastoEliminar);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el gasto: "+e.getMessage());
            em.getTransaction().rollback();
        }  finally{
            em.close();
        }
    }

    public List<Gasto> obtenerTodos() {
        List<Gasto> gastos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            gastos = em.createQuery("SELECT g FROM Gasto g", Gasto.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar los gastos: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return gastos;
    }

    @Override
    public Gasto obtenerPorId(Integer id) {
        Gasto gasto = null;
        try {
            em.getTransaction().begin();
            gasto = em.find(Gasto.class,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al listar los gastos: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return gasto;
    }
}
