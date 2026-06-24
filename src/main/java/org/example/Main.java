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

        List<Person> personsList = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        List<Passport> passportsList = em.createQuery("SELECT p FROM Passport p", Passport.class).getResultList();

        for(Person p: personsList) {
            System.out.println(p);
        }

        for(Passport pass: passportsList) {
            System.out.println(pass);
        }
    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
