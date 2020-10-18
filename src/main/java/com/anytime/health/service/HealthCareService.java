package com.anytime.health.service;


import com.anytime.health.entities.Doctor;
import com.anytime.health.entities.DoctorRequest;
import com.anytime.health.entities.DoctorResponse;
import com.anytime.health.repository.HealthCareRepository;
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

    public DoctorResponse addDoctorProfile(final DoctorRequest doctorRequest) {
        String password = UUID.randomUUID().toString();
        Doctor doctor = Doctor.builder().email(doctorRequest.getEmail())
                .password(password)
                .firstName(doctorRequest.getFirstName())
                .lastName(doctorRequest.getLastName())
                .serviceExperience(doctorRequest.getServiceExperience())
                .phoneNumber(doctorRequest.getPhoneNumber())
                .speciality(doctorRequest.getSpeciality())
                .build();
        healthCareRepository.save(doctor);
        return DoctorResponse.builder().login(doctor.getEmail()).password(password).build();
    }
}
