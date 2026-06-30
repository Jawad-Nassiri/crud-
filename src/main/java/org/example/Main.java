package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.plaf.metal.MetalBorders;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");


    public static void main(String[] args) {
        EntityManager em = createEM();

        em.getTransaction().begin();

        Product p1 = em.find(Product.class, 1L);
        p1.setName("pc");
        em.merge(p1);

        em.getTransaction().commit();
    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}