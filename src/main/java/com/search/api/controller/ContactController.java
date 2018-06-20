package com.search.api.controller;

import com.search.api.model.Contact;
import com.search.api.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
@RequestMapping("/hello")
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<Collection<Contact>> getContacts(@RequestParam(name = "nameFilter") final String nameFilter) {
        LOGGER.debug("About process: get contacts by filter phrase: {}", nameFilter);
        Collection<Contact> contacts = contactService.findContactByName(nameFilter);
        if (contacts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(contacts);
    }
}