package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.persistencia.AccesoBD;

import java.util.ArrayList;
import java.util.List;

public class PropietarioDAO implements IDAOGeneral<Propietario, Integer>{
    EntityManager em = AccesoBD.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void insertPropietario(Propietario propietario) {
        try {
            tx.begin();
            em.persist(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void updatePropietario(Propietario propietario) {
        try {
            tx.begin();
            em.merge(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void deletePropietario(Propietario propietario) {
        try {
            tx.begin();
            em.remove(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void findPropietario(int id){
        try {
            tx.begin();
            Propietario propietario = em.find(Propietario.class, id);
            System.out.println(propietario.toString());
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void listarPropietarios(){
        try {
            tx.begin();
            TypedQuery<Propietario> query = em.createQuery("Select p from Propietario p", Propietario.class);
            var propietarios=query.getResultList();
            propietarios.forEach(p->{
                System.out.println(p.toString());
            });
        } catch (Exception e) {
            System.out.println("Error al listar propietarios: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void insertar(Propietario propietario) {
        try {
            tx.begin();
            em.persist(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }

    @Override
    public void actualizar(Propietario propietario) {
        try {
            tx.begin();
            em.merge(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            tx.begin();
            Propietario propietario = em.find(Propietario.class, id);
            em.remove(propietario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
    }

    @Override
    public List<Propietario> obtenerTodos() {
        List<Propietario> propietarios = new ArrayList<>();
        try {
            tx.begin();
            TypedQuery<Propietario> query = em.createQuery("Select p from Propietario p", Propietario.class);
            propietarios=query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar propietarios: " + e.getMessage());
        } finally {
            em.close();
        }
        return propietarios;
    }

    @Override
    public Propietario obtenerPorId(Integer id) {
        Propietario propietario = null;
        try {
            tx.begin();
            propietario = em.find(Propietario.class, id);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar propietario: " + e.getMessage());
        } finally{
            em.close();
        }
        return propietario;
    }
}
