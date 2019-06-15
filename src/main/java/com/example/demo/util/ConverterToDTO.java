package com.example.demo.util;

import com.example.demo.model.dto.AddressDTO;
import com.example.demo.model.dto.ContactDTO;
import com.example.demo.model.entity.AddressEntity;
import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.PhoneEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterToDTO {

    public static ContactDTO convertContactEntityToContactDTO(
            ContactEntity contactEntity, List<AddressEntity> addressEntities, List<PhoneEntity> phoneEntities) {
        return ContactDTO.builder()
                .fullName(contactEntity.getFullName())
                .email(contactEntity.getEmail())
                .phones(phoneEntities.stream().map(PhoneEntity::getPhone).collect(Collectors.toList()))
                .addresses(addressEntities.stream().map(address -> convertAddressEntityToAddressDTO(address)).collect(Collectors.toList()))
                .build();
    }

    public static AddressDTO convertAddressEntityToAddressDTO(AddressEntity addressEntity) {
        return AddressDTO.builder()
                .country(addressEntity.getCountry())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .houseNumber(addressEntity.getHouseNumber())
                .apartment(addressEntity.getApartment())
                .build();
    }
}
