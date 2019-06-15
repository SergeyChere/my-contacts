package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Builder
public class ContactDTO {
    private String fullName;
    private String email;
    List<String> phones;
    List<AddressDTO> addresses;
}
