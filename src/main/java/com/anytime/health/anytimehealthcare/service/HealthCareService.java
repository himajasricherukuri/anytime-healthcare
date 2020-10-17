package com.anytime.health.anytimehealthcare.service;


import com.anytime.health.anytimehealthcare.entities.Doctor;
import com.anytime.health.anytimehealthcare.entities.DoctorResponse;
import com.anytime.health.anytimehealthcare.repository.HealthCareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class HealthCareService {

    private HealthCareRepository healthCareRepository;

    public HealthCareService(final HealthCareRepository healthCareRepository) {
        this.healthCareRepository = healthCareRepository;
    }


    public ArrayList<String> readAllAvailableMedicalServices() {

        ArrayList<String> specialities = new ArrayList<>();
        specialities.add("Allergy and Immunology");
        specialities.add("Anesthesiology");
        specialities.add("Colon and Rectal Surgery");
        specialities.add("Dermatology");
        return specialities;
    }

    public DoctorResponse addDoctorProfile(Doctor doctor) {
        String password = UUID.randomUUID().toString();
        doctor = Doctor.builder()
                .password(password)
                .build();
        healthCareRepository.save(doctor);
        return DoctorResponse.builder().login(doctor.getEmail()).password(password).build();
    }
}
