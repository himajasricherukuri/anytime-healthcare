package com.anytime.health.anytimehealthcare.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Consumer {

    @Id
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private int phoneNumber;

}
