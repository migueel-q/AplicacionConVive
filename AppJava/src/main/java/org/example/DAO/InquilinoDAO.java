package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Inquilino;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class InquilinoDAO implements IDAOGeneral<Inquilino, Integer>{

    EntityManager em = AccesoBD.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    @Override
    public void insertar(Inquilino inquilino) {
        try {
            tx.begin();
            em.persist(inquilino);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    @Override
    public void actualizar(Inquilino inquilino) {
        try {
            tx.begin();
            em.merge(inquilino);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            tx.begin();
            Inquilino inquilino = em.find(Inquilino.class, id);
            em.remove(inquilino);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    @Override
    public List<Inquilino> obtenerTodos(){
        List<Inquilino> inquilinos = new ArrayList<>();
        try {
            tx.begin();
            TypedQuery<Inquilino> query = em.createQuery("Select i from Inquilino i", Inquilino.class);
            inquilinos=query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar inquilinos: " + e.getMessage());
        } finally {
            em.close();
        }
        return inquilinos;
    }

    @Override
    public Inquilino obtenerPorId(Integer id) {
        Inquilino inquilino = null;
        try {
            tx.begin();
            inquilino = em.find(Inquilino.class, id);
            System.out.println(inquilino.toString());
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
        return inquilino;
    }
}
