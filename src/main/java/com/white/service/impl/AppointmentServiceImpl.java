package com.white.service.impl;

import com.white.entity.Appointment;
import com.white.entity.Dentist;
import com.white.entity.Patient;
import com.white.repository.AppointmentRepository;
import com.white.repository.DentistRepository;
import com.white.repository.PatientRepository;
import com.white.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DentistRepository dentistRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Appointment getAppointment(Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        Patient patient = patientRepository.findById(appointment.getPatient().getId()).get();
        Dentist dentist = dentistRepository.findById(appointment.getDentist().getId()).get();
        appointment.setPatient(patient);
        appointment.setDentist(dentist);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
