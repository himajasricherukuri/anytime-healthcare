package com.anytime.health.controller;

import com.anytime.health.entities.Doctor;
import com.anytime.health.entities.DoctorResponse;
import com.anytime.health.service.HealthCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCareController {


    private HealthCareService healthCareService;

    @Autowired
    public HealthCareController(HealthCareService healthCareService) {
        this.healthCareService = healthCareService;
    }


    /*
     * Services available in the portal.
     * */

    @RequestMapping(value = "/specialities/all", method = RequestMethod.GET)
    public ResponseEntity<String> readAllMedicalServices() {
        return new ResponseEntity<String>(String.valueOf(healthCareService.readAllAvailableMedicalServices()),
                HttpStatus.OK);
    }

    /*
     *Endpoints to add new Doctors to the portal.
     *
     * */
    @PostMapping(value = "/doctor/add", consumes = {"json/application"})
    public ResponseEntity<DoctorResponse> addDoctorProfile(@RequestParam("doctor") Doctor doctor) {
        DoctorResponse doctorResponse = healthCareService.addDoctorProfile(doctor);
        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor/get/{}", method = RequestMethod.GET)
    public String readDoctorProfile() {
        return "Serve the Doctor profile";
    }

    @RequestMapping(value = "/doctor/update", method = RequestMethod.PUT)
    public String updateDoctorProfile() {
        return "Updated the Doctor profile";
    }

    @RequestMapping(value = "/doctor/delete", method = RequestMethod.DELETE)
    public String deleteDoctorProfile() {
        return "Updated the Doctor profile";
    }


    /*
     *Endpoints to add new Customers or Patients to the portal.
     *
     * */
    @RequestMapping(value = "/consumer/add", method = RequestMethod.POST)
    public String addPatientProfile() {
        return "Added a new Patient to the anytime-healthcare portal";
    }

    @RequestMapping(value = "/consumer/get/{}", method = RequestMethod.GET)
    public String readPatientProfile() {
        return "Serve the Patient profile";
    }

    @RequestMapping(value = "/consumer/update", method = RequestMethod.PUT)
    public String updatePatientProfile() {
        return "Updated the Patient profile";
    }

    @RequestMapping(value = "/consumer/delete", method = RequestMethod.DELETE)
    public String deletePatientProfile() {
        return "Updated the Patient profile";
    }


}
