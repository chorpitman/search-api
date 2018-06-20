package com.search.api.populator;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Init {
    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    void init() {
        Contact contact1 = Contact.builder()
                .name("Dmytro").build();

        Contact contact2 = Contact.builder()
                .name("Mrok").build();

        Contact contact3 = Contact.builder()
                .name("Azur").build();

        Contact contact4 = Contact.builder()
                .name("Zork").build();

        contactRepository.saveAll(Arrays.asList(contact1, contact2, contact3, contact4));
    }
}