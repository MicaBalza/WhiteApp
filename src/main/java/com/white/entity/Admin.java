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
@DiscriminatorValue("Admin")
public class Admin extends User {

    public Admin(String email, String password, Timestamp creationDate) {
        super(email, password, creationDate);
    }

    public Admin() {
    }
}
