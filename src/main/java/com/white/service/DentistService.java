package com.white.service;

import com.white.entity.Dentist;

import java.util.List;

public interface DentistService {

    void saveDentist(Dentist dentist);

    Dentist getDentist(Integer id);

    List<Dentist> getAllDentists();

    void deleteDentist(Integer id);
}
