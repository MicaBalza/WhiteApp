package com.white.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("Dentist")
public class Dentist extends User {

    private String license;

    public Dentist(String email, String password, Timestamp creationDate, String license) {
        super(email, password, creationDate);
        this.license = license;
    }

    public Dentist(String license) {
        this.license = license;
    }

    public Dentist() {}
}
