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

        Person p = em.find(Person.class, 25);
        Passport passport = em.find(Passport.class, 25);

        p.setName("Leo");
        passport.setNumber("LN225588");
        

        em.getTransaction().commit();



    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
