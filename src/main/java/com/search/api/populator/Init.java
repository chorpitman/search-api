package com.search.api.populator;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

@Component
public class Init {
    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    void init() {
        if (contactRepository.findAll().isEmpty()) {
            Contact contact1 = Contact.builder()
                    .name("Dmytro").build();

            Contact contact2 = Contact.builder()
                    .name("Mrok").build();

            Contact contact3 = Contact.builder()
                    .name("Azur").build();

            Contact contact4 = Contact.builder()
                    .name("Zork").build();

            Contact contact5 = Contact.builder()
                    .name("Anton").build();

            Contact contact6 = Contact.builder()
                    .name("Bruno").build();

            Contact contact7 = Contact.builder()
                    .name("Cody").build();

            Contact contact8 = Contact.builder()
                    .name("Irson").build();

            contactRepository.saveAll(asList(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8));
        }
    }
}