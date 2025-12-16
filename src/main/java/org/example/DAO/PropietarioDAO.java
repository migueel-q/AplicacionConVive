package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.persistencia.AccesoBD;

public class PropietarioDAO {
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
}
