package com.example.demo.service;

import com.example.demo.model.dto.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    ContactDTO getContact(Long id);

    List<ContactDTO> getAllContacts();
    List<ContactDTO> getAllContactsByName(String name);

    List<ContactDTO> getAllContactsByPhone(String phone);

    void createContact(ContactDTO contactDTO);
    void deleteContact(Long id);
}
