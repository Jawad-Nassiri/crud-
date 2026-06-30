package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");


    public static void main(String[] args) {
        EntityManager em = createEM();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM User").executeUpdate();


        em.getTransaction().commit();
        em.close();
        emf.close();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}