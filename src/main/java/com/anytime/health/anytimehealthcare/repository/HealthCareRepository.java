package com.anytime.health.anytimehealthcare.repository;


import com.anytime.health.anytimehealthcare.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HealthCareRepository extends CrudRepository<Doctor, UUID> {

}
