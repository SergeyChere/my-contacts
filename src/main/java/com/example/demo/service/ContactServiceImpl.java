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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    ConverterToDTO converterToDTO;

    @Autowired
    ConverterFromDTO converterFromDTO;

    @Override
    @Transactional
    public void createContact(ContactDTO contactDTO) {
        ContactEntity contactEntity = converterFromDTO.convertContactDTOToContactEntity(contactDTO);
        List<PhoneEntity> phones = converterFromDTO.convertPhoneStringToPhoneEntity(contactDTO, contactEntity);
        List<AddressEntity> addresses = converterFromDTO.convertAddressDTOToAddressEntity(contactDTO, contactEntity);

        contactRepo.save(contactEntity);
        phoneRepo.saveAll(phones);
        addressRepo.saveAll(addresses);
    }

    @Override
    @Transactional
    public void updateContact(Long id, ContactDTO contactDTO) {
        ContactEntity contactEntity = contactRepo.findById(id).orElseThrow(null);
        contactEntity = converterFromDTO.convertContactDTOToContactEntityForUpdate(id, contactDTO);

        List<PhoneEntity> phones = converterFromDTO.convertPhoneStringToPhoneEntity(contactDTO, contactEntity);
        List<AddressEntity> addresses = converterFromDTO.convertAddressDTOToAddressEntity(contactDTO, contactEntity);

        phoneRepo.deleteAllByContactEntity(contactEntity);
        addressRepo.deleteAllByContactEntity(contactEntity);

        contactRepo.save(contactEntity);
        phoneRepo.saveAll(phones);
        addressRepo.saveAll(addresses);
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
        List<PhoneEntity> phoneEntities = phoneRepo.findAllByPhone(phone);
        return phoneEntities.stream().map(phoneelement
                -> getContact(phoneelement.getContactEntity().getId())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContactsByName(String fullname) {
        List<ContactEntity> names = contactRepo.findAllByFullName(fullname);
        return names.stream().map(name -> getContact(name.getId())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactDTO getContact(Long id) {
        ContactEntity contactEntity = contactRepo.findById(id).orElseThrow(null);
        List<AddressEntity> addressEntities = addressRepo.findAllByContactEntityId(id);
        List<PhoneEntity> phoneEntities = phoneRepo.findByContactEntityId(id);
        return converterToDTO.convertContactEntityToContactDTO(contactEntity, addressEntities, phoneEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContacts() {
        List<Long> contactsIDS = contactRepo.getAllContactsId();
        return contactsIDS.stream().map(id -> getContact(id)).collect(Collectors.toList());
    }
}
