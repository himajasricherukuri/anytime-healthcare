package com.anytime.health.repository;


import com.anytime.health.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HealthCareRepository extends CrudRepository<Doctor, UUID> {

}
