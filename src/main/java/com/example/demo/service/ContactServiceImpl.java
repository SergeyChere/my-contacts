package com.example.demo.service;

import com.example.demo.model.dto.ContactDTO;
import com.example.demo.model.entity.AddressEntity;
import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.PhoneEntity;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.ContactRepo;
import com.example.demo.repo.PhoneRepo;
import com.example.demo.util.ConverterFromDTO;
import com.example.demo.util.ConverterToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    PhoneRepo phoneRepo;

    @Autowired
    AddressRepo addressRepo;

    @Override
//    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(ContactDTO contactDTO) {
        ContactEntity contactEntity = ConverterFromDTO.convertContactDTOToContactEntity(contactDTO);
//        List<PhoneEntity> phones = ConverterFromDTO.createAddress(contactDTO, contactEntity);
//        List<AddressEntity> addresses = ConverterFromDTO.convertAddressDTOToAddressEntity(contactDTO, contactEntity);

        contactRepo.save(contactEntity);
//        phoneRepo.saveAll(phones);
//        addressRepo.saveAll(addresses);
    }

//    public static PhoneEntity createAddress(ContactEntity contactEntity, ContactDTO contactDTO, String phone) {
//        return (PhoneEntity) contactDTO.getPhones().stream().map(phoneelement -> ConverterFromDTO.putPhoneToPhoneEntity(contactEntity, phoneelement)).collect(Collectors.toList());
//    }
//
//    public static List<PhoneEntity> foo(ContactDTO contactDTO, ContactEntity contactEntity) {
//        return contactDTO.getPhones().stream()
//                .map(phone -> boo(phone, contactEntity))
//                .collect(Collectors.toList());
//    }
//
//    private PhoneEntity boo(String phoneElement, ContactEntity contactEntity) {
//        PhoneEntity phoneEntity = phoneRepo.findPhoneByPhone(phone).orElse(
//
//        phoneEntity.getUser().add(user);
//        return phoneEntity;
//    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContactsByName(String fullname) {
        List<ContactEntity> names = contactRepo.findAllByFullName(fullname);
        return names.stream().map(name -> getContact(name.getId())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteContact(Long id) {
        ContactEntity contactEntity = contactRepo.findById(id).orElseThrow(null);
        phoneRepo.deleteAllByContactEntity(contactEntity);
        addressRepo.deleteAllByContactEntity(contactEntity);
        contactRepo.delete(contactEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContactsByPhone(String phone) {
        List<PhoneEntity> phoneEntities = phoneRepo.findByPhoneOrderByContactEntityId(phone);
        System.out.println(phoneEntities);
        List<ContactEntity> contactEntities = phoneEntities.stream().map(elementPhone -> elementPhone.getContactEntity()).collect(Collectors.toList());
        System.out.println(contactEntities);
        List<AddressEntity> addressEntities =
                contactEntities.stream().map(contact -> addressRepo.findByContactEntity(contact)).collect(Collectors.toList());
        System.out.println(addressEntities);
        return contactEntities.stream().map(contactEntity
                -> ConverterToDTO.convertContactEntityToContactDTO(contactEntity, addressEntities, phoneEntities)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactDTO getContact(Long id) {
        ContactEntity contactEntity = contactRepo.findById(id).orElseThrow(null);
        List<AddressEntity> addressEntities = addressRepo.findAllByContactEntityId(id);
        List<PhoneEntity> phoneEntities = phoneRepo.findByContactEntityId(id);
        return ConverterToDTO.convertContactEntityToContactDTO(contactEntity, addressEntities, phoneEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContacts() {
        List<Long> contactsIDS = contactRepo.getAllContactsId();
        return contactsIDS.stream().map(id -> getContact(id)).collect(Collectors.toList());
    }
}
