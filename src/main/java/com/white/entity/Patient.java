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
//@DiscriminatorValue("Patient")
public class Patient extends User {

    private String dni;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Appointment> appointmentsList;

    public Patient(String email, String password, String name, String lastname, Timestamp creationDate, String dni, Address address) {
        super(email, password, name, lastname, creationDate);
        this.dni = dni;
        this.address = address;
    }

    public Patient(String dni, Address address) {
        this.dni = dni;
        this.address = address;
    }

    public Patient() {};
}
