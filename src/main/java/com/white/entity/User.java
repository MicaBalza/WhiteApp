package com.white.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Timestamp creationDate;

    public User(String email, String password, String name, String lastname, Timestamp creationDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.creationDate = creationDate;
    }

    public User() {
    }
}
