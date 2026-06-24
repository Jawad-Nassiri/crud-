package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPU");

    public static void main(String[] args) {

        EntityManager em = createEM();

        em.getTransaction().begin();

        User firstUser = new User();
        firstUser.setName("Leo");
        firstUser.setAge(27);

        Order firstOrder = new Order();
        firstOrder.setName("Acer CJ750");
        BigDecimal price = new BigDecimal("899.99");
        firstOrder.setPrice(price);

        firstOrder.setUser(firstUser);
        firstUser.getOrders().add(firstOrder);

        em.persist(firstUser);
        em.persist(firstOrder);

        em.getTransaction().commit();


    }


    public static EntityManager createEM() {
        return emf.createEntityManager();
    }
}
