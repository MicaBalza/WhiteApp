package com.white.controller;

import com.white.entity.Dentist;
import com.white.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping("/new")
    public ResponseEntity<Dentist> addDentist(@RequestBody Dentist dentist) {
        dentistService.saveDentist(dentist);
        return new ResponseEntity(dentist, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getDentistById(@PathVariable("id") Integer id) {
        ResponseEntity response = null;
        Dentist dentist = dentistService.getDentist(id);
        if (dentist != null) {
            response = new ResponseEntity(dentist, HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }


}
