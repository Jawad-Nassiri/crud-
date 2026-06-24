package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column
    @Getter
    @Setter
    private String number;

    @OneToOne
    @JoinColumn(name = "person_id")
    @Getter
    @Setter
    private Person person;

    public Passport() {}
}
