package com.white.service;

import com.white.entity.Dentist;
import com.white.entity.Patient;

import java.util.List;

public interface PatientService {

    void savePatient(Patient patient);

    Patient getPatient(Integer id);

    List<Patient> getAllPatients();

    void deletePatient(Integer id);
}