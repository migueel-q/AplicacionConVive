package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Oferta;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class OfertaDAO implements IDAOGeneral<Oferta, Integer> {

    EntityManager em = AccesoBD.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public void insertar(Oferta oferta) {
        try {
            tx.begin();
            em.persist(oferta);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar Oferta: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Oferta oferta) {
        try {
            tx.begin();
            em.merge(oferta);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar Oferta: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            tx.begin();
            Oferta oferta = em.find(Oferta.class, id);
            em.remove(oferta);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar Oferta: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Oferta> obtenerTodos() {
        List<Oferta> ofertas = new ArrayList<Oferta>();
        try {
            tx.begin();
            TypedQuery<Oferta> query = em.createQuery("Select o from Oferta o", Oferta.class);
            ofertas = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar ofertas: " + e.getMessage());
        } finally {
            em.close();
        }
        return ofertas;
    }


    @Override
    public Oferta obtenerPorId(Integer id) {
        Oferta oferta = null;
        try {
            tx.begin();
            oferta = em.find(Oferta.class, id);
            System.out.println(oferta.toString());
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar Oferta: " + e.getMessage());
        } finally {
            em.close();
        }
        return oferta;
    }
}
