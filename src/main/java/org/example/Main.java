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

        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();

        for(Product p: products) {
            System.out.println(p);
        }

        for(Order o: orders) {
            System.out.println(o);
        }

    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}