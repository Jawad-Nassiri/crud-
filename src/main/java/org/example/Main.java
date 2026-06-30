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

        User user = new User("Jawad", "Jawad1212@yahoo.com");
        Profile profile = new Profile("Software Developer", "0780476694");

        user.setProfile(profile);
        profile.setUser(user);

        em.persist(profile);



        em.getTransaction().commit();
        em.close();
        emf.close();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}