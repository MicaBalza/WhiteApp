package com.white.service;

import com.white.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    void saveAppointment(Appointment appointment);

    Appointment getAppointment(Integer id);

    List<Appointment> getAllAppointments();

    void deleteAppointment(Integer id);
}
