package com.example.demo.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Builder
public class PhoneEntity {

    @Id
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Past
    LocalDateTime time;

    @NotBlank
    private String phone;

    @ManyToOne
    private ContactEntity contactEntity;
}
