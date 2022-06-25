package com.white.controller;

import com.white.entity.Patient;
import com.white.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id) {
        ResponseEntity response = null;
        Patient patient = patientService.getPatient(id);
        if (patient != null) {
            response = new ResponseEntity(patient, HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return new ResponseEntity(patient, HttpStatus.CREATED);
    }
}
