package com.example.demo.controller;

import com.example.demo.model.dto.ContactDTO;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactService contactService;

    //Get
    @GetMapping(value = "/getContact")
    private ContactDTO getContact(@RequestParam(name = "id") Long id) {
        return contactService.getContact(id);
    }

    @GetMapping(value = "/getAllContacts")
    private List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping(value = "/getAllContactsByName")
    List<ContactDTO> getAllContactsByName(@RequestParam(name = "name") String name) {
        return contactService.getAllContactsByName(name);
    }

    @GetMapping(value = "/getContactByPhone")
    List<ContactDTO> getAllContactsByPhone(@RequestParam(name = "phone") String phone) {
        return contactService.getAllContactsByPhone(phone);
    }

    //Create
    @PostMapping(value = "/createNewContact")
    private void createNewContact(@RequestBody ContactDTO contactDTO) {
        contactService.createContact(contactDTO);
    }

    //Delete
    @DeleteMapping(value = "/deleteContact")
    private void deleteContact(@RequestParam(name = "id") Long id) {
        contactService.deleteContact(id);
    }
}
