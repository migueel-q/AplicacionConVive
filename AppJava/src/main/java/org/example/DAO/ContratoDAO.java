package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Contrato;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class ContratoDAO implements IDAOGeneral<Contrato, Integer> {

    EntityManager em = AccesoBD.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public void insertar(Contrato contrato) {
        try {
            tx.begin();
            em.persist(contrato);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar Contrato: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Contrato contrato) {
        try {
            tx.begin();
            em.merge(contrato);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar Contrato: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            tx.begin();
            Contrato contrato = em.find(Contrato.class, id);
            em.remove(contrato);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar Contrato: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Contrato> obtenerTodos() {
        List<Contrato> contratos = new ArrayList<Contrato>();
        try {
            tx.begin();
            TypedQuery<Contrato> query = em.createQuery("Select c from Contrato c", Contrato.class);
            contratos = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar contratos: " + e.getMessage());
        } finally {
            em.close();
        }
        return contratos;
    }

    @Override
    public Contrato obtenerPorId(Integer id) {
        Contrato contrato = null;
        try {
            tx.begin();
            contrato = em.find(Contrato.class, id);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar Contrato: " + e.getMessage());
        } finally {
            em.close();
        }
        return contrato;
    }
}
