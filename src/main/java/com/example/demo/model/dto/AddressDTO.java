package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AddressDTO {

    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String apartment;
}
