package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");


    public static void main(String[] args) {
        EntityManager em = createEM();

//      get one user
        User user16 = em.find(User.class, 16L);
        System.out.println(user16);

//      get all users
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        for(User u: users) {
            System.out.println(u);
        }

        em.close();
        emf.close();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}