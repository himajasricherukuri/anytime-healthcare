package com.anytime.health.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HealthService {

    @Id
    private UUID uuid;

    private String patientFirstName;

    private String patientLastName;

    private String healthIssue;

    private String speciality;

    private int severity;

}
