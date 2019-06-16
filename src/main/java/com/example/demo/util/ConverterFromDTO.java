package com.example.demo.util;

import com.example.demo.model.dto.AddressDTO;
import com.example.demo.model.dto.ContactDTO;
import com.example.demo.model.entity.AddressEntity;
import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.PhoneEntity;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.PhoneRepo;
import com.example.demo.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterFromDTO {

    public static ContactEntity convertContactDTOToContactEntity(ContactDTO contactDTO) {
        ContactEntity contactEntity = ContactEntity.builder()
                .fullName(contactDTO.getFullName())
                .time(LocalDateTime.now())
                .email(contactDTO.getEmail())
                .build();
        return contactEntity;
    }

    public static List<AddressEntity> convertAddressDTOToAddressEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
        return contactDTO.getAddresses().stream().map(address
                -> convertAddressDtoToAddress(contactEntity, address)).collect(Collectors.toList());
    }

    public static AddressEntity convertAddressDtoToAddress(ContactEntity contactEntity, AddressDTO addressDTO) {
        AddressEntity addressEntity = AddressEntity.builder()
                .time(LocalDateTime.now())
                .country(addressDTO.getCountry())
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .houseNumber(addressDTO.getHouseNumber())
                .apartment(addressDTO.getApartment())
                .build();
        addressEntity.setContactEntity(contactEntity);
        return addressEntity;
    }

    public static List<PhoneEntity> convertPhoneStringToPhoneEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
        return contactDTO.getPhones().stream().map(phone
                -> convertPhonesStringToPhoneEntity(contactEntity, phone, contactDTO)).collect(Collectors.toList());
    }

    //This method don't work
    public static PhoneEntity convertPhonesStringToPhoneEntity(
            ContactEntity contactEntity, String phoneelement, ContactDTO contactDTO) {
        PhoneEntity phoneEntity = PhoneEntity.builder()
                .time(LocalDateTime.now()
                .(contactDTO.getPhones(newphone -> ))
                .build();
        phoneEntity.setContactEntity(contactEntity);
        return phoneEntity;
    }
}