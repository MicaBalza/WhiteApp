package com.white.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table
//@DiscriminatorValue("Dentist")
public class Dentist extends User {

    private String license;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Appointment> appointmentsList;

    public Dentist(String email, String password, String name, String lastname, Timestamp creationDate, String license) {
        super(email, password, name, lastname, creationDate);
        this.license = license;
    }

    public Dentist(String license) {
        this.license = license;
    }

    public Dentist() {}
}
