package org.example;

import jakarta.persistence.EntityManager;
import org.example.persistencia.AccesoBD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);} {
        EntityManager em = AccesoBD.getEntityManager();
        em.getTransaction().begin();
        em.close();
    }
}