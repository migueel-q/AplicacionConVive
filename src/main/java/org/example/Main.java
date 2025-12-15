package org.example;

import jakarta.persistence.EntityManager;
import org.example.persistencia.AccesoBD;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManager em = AccesoBD.getEntityManager();
        em.getTransaction().begin();
        em.close();
    }
}