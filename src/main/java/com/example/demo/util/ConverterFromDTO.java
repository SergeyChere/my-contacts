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

//    public static List<AddressEntity> convertAddressDTOToAddressEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
//        return contactDTO.getAddresses().stream().map(address -> convertAddressDtoToAddress(contactEntity, address)).collect(Collectors.toList());
//    }
//
//    public static AddressEntity convertAddressDtoToAddress(ContactEntity contactEntity, AddressDTO addressDTO) {
//        AddressEntity addressEntity = AddressEntity.builder()
//                .time(LocalDateTime.now())
//                .country(addressDTO.getCountry())
//                .city(addressDTO.getCity())
//                .street(addressDTO.getStreet())
//                .houseNumber(addressDTO.getHouseNumber())
//                .apartment(addressDTO.getApartment())
//                .build();
//        addressEntity.setContactEntity(contactEntity);
//        return addressEntity;
//    }

//    public static PhoneEntity putPhoneToPhoneEntity(ContactEntity contactEntity, String phoneElement) {
//         PhoneEntity phoneEntity = PhoneEntity.builder()
//                .time(LocalDateTime.now())
//                .phone(phoneElement)
//                .build();
//        phoneEntity.setContactEntity(contactEntity);
//        return phoneEntity;
//    }
//
//    public static List<PhoneEntity> convertPhoneDTOToPhoneEntity(ContactDTO contactDTO, ContactEntity contactEntity) {
//            return contactDTO.getPhones().stream()
//                    .map(phone -> getPhoneNumberFromString(phone, contactEntity))
//                    .collect(Collectors.toList());
//        }
//    }
//
//    private PhoneEntity convertPhoneDTOToPhoneEntity(String phone, ContactEntity contactEntity) {
//        PhoneEntity phoneEntity = phoneRepo.findPhoneNumberByPhoneNumber(phone).orElse(null);
//        return PhoneEntity.builder()
//                        .time(LocalDateTime.now())
//                        .phoneEntity(phone)
//                        .user(new ArrayList<>())
//                        .build());
//
//        phoneNumberFromDB.getUser().add(user);
//
//        return phoneNumberFromDB;
//    }
}
