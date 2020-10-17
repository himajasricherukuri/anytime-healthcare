package com.anytime.health.anytimehealthcare.entities;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DoctorResponse {

    private String login;
    private String password;

}
