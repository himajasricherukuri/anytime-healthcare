package com.anytime.health.controller;

import com.anytime.health.entities.DoctorPayload;
import com.anytime.health.entities.HealthRequest;
import com.anytime.health.service.HealthCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
//    @PostMapping(value = "/doctor/add")
//    public ResponseEntity<DoctorPayload> addDoctorProfile(@RequestBody final DoctorPayload doctor) {
//        //DoctorPayload doctorResponse = healthCareService.addDoctorProfile(doctor);
//        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
//    }

    @PostMapping(path = "/doctor/create",
            consumes = {"multipart/form-data"})
    public ResponseEntity<DoctorPayload> addDoctorProfile(@RequestPart(value = "portfolio") MultipartFile[] portfolio,
                                                          @RequestParam(value = "email", required = false) String email,
                                                          @RequestParam(value = "firstName", required = false) String firstName,
                                                          @RequestParam(value = "lastName", required = false) String lastName,
                                                          @RequestParam(value = "experience", required = false) String experience,
                                                          @RequestParam(value = "phone", required = false) String phone,
                                                          @RequestParam(value = "speciality", required = false) String speciality) {
        DoctorPayload doctorResponse = healthCareService.addDoctorProfile(email, firstName, lastName, experience, phone, speciality);
        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/doctor/get/{email}")
    public ResponseEntity<DoctorPayload> readDoctorProfile(@PathVariable final String email) {
        return new ResponseEntity<>(healthCareService.readDoctorProfile(email), HttpStatus.OK);
    }

    @GetMapping(value = "/doctor/all")
    public ResponseEntity<List<DoctorPayload>> readAllDoctorProfiles() {
        return new ResponseEntity<>(healthCareService.readAllDoctors(), HttpStatus.OK);
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

    /*
     * Health Request Management
     * */
    @PostMapping(value = "/health/servicerequest/create")
    public ResponseEntity<String> createHealthServiceRequest(@RequestBody final HealthRequest healthRequest) {
        return new ResponseEntity<>("A Service request has been submitted. Someone will be with you in next few mins",
                HttpStatus.OK);
    }


}
