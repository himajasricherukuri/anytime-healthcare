package com.anytime.health.service;


import com.anytime.health.entities.Doctor;
import com.anytime.health.entities.DoctorPayload;
import com.anytime.health.repository.HealthCareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public DoctorPayload addDoctorProfile(final String email,
                                          final String firstName,
                                          final String lastName,
                                          final String experience,
                                          final String phone,
                                          final String speciality) {
        String password = UUID.randomUUID().toString();
        Doctor doctor = Doctor.builder().email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .serviceExperience(experience)
                .phoneNumber(phone)
                .speciality(speciality)
                .build();
        healthCareRepository.save(doctor);
        return DoctorPayload.builder().build().builder().email(doctor.getEmail()).password(password).build();
    }

    public DoctorPayload readDoctorProfile(final String email) {
        DoctorPayload doctorPayload = null;
        Optional<Doctor> doctor = healthCareRepository.findById(email);
        return doctorPayload.builder().email(doctor.get().getEmail())
                .firstName(doctor.get().getFirstName())
                .lastName(doctor.get().getLastName())
                .phoneNumber(doctor.get().getPhoneNumber())
                .serviceExperience(doctor.get().getServiceExperience())
                .speciality(doctor.get().getSpeciality())
                .rating(1)
                .build();
    }

    public List<DoctorPayload> readAllDoctors() {
        DoctorPayload doctorPayload = null;
        ArrayList<DoctorPayload> doctorPayloads = new ArrayList<>();
        Iterable<Doctor> doctorFromDB = healthCareRepository.findAll();
        doctorFromDB.forEach(doctor ->
                doctorPayloads.add(doctorPayload.builder().email(doctor.getEmail())
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .phoneNumber(doctor.getPhoneNumber())
                        .serviceExperience(doctor.getServiceExperience())
                        .speciality(doctor.getSpeciality())
                        .rating(1)
                        .build()));
        return doctorPayloads;
    }
}
