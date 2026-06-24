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

        Person p1 = new Person();
        p1.setName("John");
        Passport pass1 = new Passport();
        pass1.setNumber("A123");

        Person p2 = new Person();
        p2.setName("Ali");
        Passport pass2 = new Passport();
        pass2.setNumber("B456");

        Person p3 = new Person();
        p3.setName("Jawad");
        Passport pass3 = new Passport();
        pass3.setNumber("C789");

        Person p4 = new Person();
        p4.setName("Maria");
        Passport pass4 = new Passport();
        pass4.setNumber("D321");

        Person p5 = new Person();
        p5.setName("Lucas");
        Passport pass5 = new Passport();
        pass5.setNumber("E654");

        p1.setPassport(pass1);
        pass1.setPerson(p1);

        p2.setPassport(pass2);
        pass2.setPerson(p2);

        p3.setPassport(pass3);
        pass3.setPerson(p3);

        p4.setPassport(pass4);
        pass4.setPerson(p4);

        p5.setPassport(pass5);
        pass5.setPerson(p5);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);

        em.persist(pass1);
        em.persist(pass2);
        em.persist(pass3);
        em.persist(pass4);
        em.persist(pass5);



       em.getTransaction().commit();



    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
