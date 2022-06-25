package com.white.service.impl;

import com.white.entity.Dentist;
import com.white.repository.DentistRepository;
import com.white.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public void saveDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public Dentist getDentist(Integer id) {
        return dentistRepository.getReferenceById(id);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public void deleteDentist(Integer id) {
        dentistRepository.deleteById(id);
    }
}
