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

        Person p = em.find(Person.class, 2);
        Passport passport = em.find(Passport.class, 2);


        if(p != null && passport != null) {
            System.out.println(p);
            System.out.println(passport);
        } else {
            System.out.println("Data do not exist !");
        }



    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
