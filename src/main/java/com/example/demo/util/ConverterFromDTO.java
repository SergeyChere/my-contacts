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

    public ContactEntity convertContactDTOToContactEntity(ContactDTO contactDTO) {
        ContactEntity contactEntity = ContactEntity.builder()
                .fullName(contactDTO.getFullName())
                .time(LocalDateTime.now())
                .email(contactDTO.getEmail())
                .build();
        return contactEntity;
    }

    public List<AddressEntity> convertAddressDTOToAddressEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
        return contactDTO.getAddresses().stream().map(address
                -> convertAddressDtoToAddress(contactEntity, address)).collect(Collectors.toList());
    }

    public AddressEntity convertAddressDtoToAddress(ContactEntity contactEntity, AddressDTO addressDTO) {
        AddressEntity addressEntity = AddressEntity.builder()
                .time(LocalDateTime.now())
                .country(addressDTO.getCountry())
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .houseNumber(addressDTO.getHouseNumber())
                .apartment(addressDTO.getApartment())
                .contactEntity(contactEntity)
                .build();
        return addressEntity;
    }

    public List<PhoneEntity> convertPhoneStringToPhoneEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
        return contactDTO.getPhones().stream().map(phone
                -> convertPhonesStringToPhoneEntity(contactEntity, phone)).collect(Collectors.toList());
    }

    public PhoneEntity convertPhonesStringToPhoneEntity(
            ContactEntity contactEntity, String phoneelement) {
        PhoneEntity phoneEntity = PhoneEntity.builder().phone(phoneelement).time(LocalDateTime.now()).contactEntity(contactEntity).build();
        return phoneEntity;
    }

    public ContactEntity convertContactDTOToContactEntityForUpdate(Long id, ContactDTO contactDTO) {
        ContactEntity contactEntity = ContactEntity.builder()
                .id(id)
                .fullName(contactDTO.getFullName())
                .time(LocalDateTime.now())
                .email(contactDTO.getEmail())
                .build();
        return contactEntity;
    }
}
