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
        List<User> users = new ArrayList<>();

        users.add(new User("Leo", "leo@yahoo.fr"));
        users.add(new User("Emma", "emma@gmail.com"));
        users.add(new User("Noah", "noah@gmail.com"));
        users.add(new User("Liam", "liam@yahoo.fr"));
        users.add(new User("Mia", "mia@gmail.com"));
        users.add(new User("Lucas", "lucas@gmail.com"));
        users.add(new User("Sofia", "sofia@yahoo.fr"));
        users.add(new User("Ethan", "ethan@gmail.com"));
        users.add(new User("Chloe", "chloe@yahoo.fr"));
        users.add(new User("Adam", "adam@gmail.com"));

        for(User u: users) {
            em.persist(u);
        }



        em.getTransaction().commit();
        em.close();
        emf.close();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}