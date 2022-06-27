package com.white.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentistId")
    private Dentist dentist;
    private Timestamp dateTime;

    public Appointment(Patient patient, Dentist dentist, Timestamp dateTime) {
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }

    public Appointment() {
    }
}
