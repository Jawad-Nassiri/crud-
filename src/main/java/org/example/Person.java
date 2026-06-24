package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@ToString(exclude = "passport")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column
    @Getter
    @Setter
    private String name;

    @OneToOne(mappedBy = "person")
    @Getter
    @Setter
    private Passport passport;


    public Person() {}

}
