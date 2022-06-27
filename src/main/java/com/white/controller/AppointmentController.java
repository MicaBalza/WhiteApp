package com.white.controller;

import com.white.entity.Appointment;
import com.white.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Integer id) {
        ResponseEntity response = null;
        Appointment appointment = appointmentService.getAppointment(id);
        if (appointment != null) {
            response = new ResponseEntity(appointment, HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/new")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return new ResponseEntity(appointment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointmentById(@PathVariable("id") Integer id) {
        Appointment appointment = appointmentService.getAppointment(id);
        if (appointment != null) {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity(appointment, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
