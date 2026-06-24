package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Setter
    @Getter
    private String name;

    @Column
    @Getter
    @Setter
    private int age;

    @Getter
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();;

    public User() {}
}
