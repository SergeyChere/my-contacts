package com.example.demo.model.dto;

import lombok.*;

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
