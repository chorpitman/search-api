package com.search.api.populator;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Init {
    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    void init() {
        if (contactRepository.findAll().isEmpty()) {
            contactRepository.saveAll(generateUsers(4_000));
        }
    }

    private List<Contact> generateUsers(final int countUser) {
        List<Contact> contacts = new ArrayList<>();
        if (countUser > 0) {
            for (int i = 0; i < countUser; i++) {
                contacts.add(Contact.builder()
                        .name(generateName())
                        .build());

            }
            return contacts;
        }
        return Collections.emptyList();
    }

    private String generateName() {
        return RandomStringUtils.randomAlphabetic(7);
    }
}