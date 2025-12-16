package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.modelos.Inquilino;
import org.example.modelos.Propietario;
import org.example.persistencia.AccesoBD;

import javax.swing.text.html.parser.Entity;

public class InquilinoDAO {

    EntityManager em = AccesoBD.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void insertInquilino(Inquilino inquilino) {
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
    public void updateInquilino(Inquilino inquilino) {
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
    public void deleteInquilino(Inquilino inquilino) {
        try {
            tx.begin();
            em.remove(inquilino);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void findInquilino(int id){
        try {
            tx.begin();
            Inquilino inquilino = em.find(Inquilino.class, id);
            System.out.println(inquilino.toString());
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al buscar Inquilino: " + e.getMessage());
        } finally{
            em.close();
        }
    }
    public void listarInquilinos(){
        try {
            tx.begin();
            TypedQuery<Inquilino> query = em.createQuery("Select i from Inquilino i", Inquilino.class);
            var inquilinos=query.getResultList();
            inquilinos.forEach(i->{
                System.out.println(i.toString());
            });
        } catch (Exception e) {
            System.out.println("Error al listar inquilinos: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
