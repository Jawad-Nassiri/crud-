package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");

    public static void main(String[] args) {

        EntityManager em = createEM();

        System.out.println("Hello World !");



    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
