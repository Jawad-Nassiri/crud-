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
        User user17 = em.find(User.class, 17L);
        System.out.println(user17);
        if(user17 != null) {
            user17.setUsername("Grace");
            em.remove(user17);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}