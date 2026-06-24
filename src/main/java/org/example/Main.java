package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");

    public static void main(String[] args) {

        EntityManager em = createEM();

        em.getTransaction().begin();

        Person p = em.find(Person.class, 25L);
        Passport passport = em.find(Passport.class, 25L);

        em.remove(passport);
        em.remove(p);

        em.getTransaction().commit();



    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
