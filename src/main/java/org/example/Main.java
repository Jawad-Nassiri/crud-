package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Date;


public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");


    public static void main(String[] args) {
        EntityManager em = createEM();

        em.getTransaction().begin();

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(BigDecimal.valueOf(1100));


        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setPrice(BigDecimal.valueOf(49.99));

        Order order1 = new Order();
        order1.setDate(new Date());

        order1.getProductList().add(p1);
        order1.getProductList().add(p2);


        em.persist(p1);
        em.persist(p2);

        em.persist(order1);


        em.getTransaction().commit();

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}