package com.search.api.populator;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class Init {
    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    void init() {
        if (contactRepository.findAll().isEmpty()) {
            contactRepository.saveAll(createContacts());
        }
    }

    List<Contact> createContacts() {
        Contact contact1 = Contact.builder()
                .name("AaihjEo").build();

        Contact contact2 = Contact.builder()
                .name("Akiyvur").build();

        Contact contact3 = Contact.builder()
                .name("AAbnnPH").build();

        Contact contact4 = Contact.builder()
                .name("ASkaKrC").build();

        Contact contact5 = Contact.builder()
                .name("AUCvkCC").build();

        Contact contact6 = Contact.builder()
                .name("ACZVpiu").build();

        Contact contact7 = Contact.builder()
                .name("ABdJbPd").build();

        Contact contact8 = Contact.builder()
                .name("ANEUUYF").build();

        Contact contact9 = Contact.builder()
                .name("AsgnBwX").build();

        Contact contact10 = Contact.builder()
                .name("AKCJQAH").build();

        Contact contact11 = Contact.builder()
                .name("cGGkkeZ").build();

        Contact contact12 = Contact.builder()
                .name("mIteZHz").build();

        Contact contact13 = Contact.builder()
                .name("iwYPgQt").build();

        Contact contact14 = Contact.builder()
                .name("iUqjCuv").build();

        Contact contact15 = Contact.builder()
                .name("XGuBpKe").build();

        Contact contact16 = Contact.builder()
                .name("uYZiKQn").build();

        Contact contact17 = Contact.builder()
                .name("dKNaldt").build();

        Contact contact18 = Contact.builder()
                .name("ANEUUYF").build();

        Contact contact19 = Contact.builder()
                .name("Owiqiiy").build();

        Contact contact20 = Contact.builder()
                .name("Akiyvur").build();

        return Arrays.asList(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8, contact9,
                contact10, contact11, contact12, contact13, contact14, contact15, contact16, contact17, contact18,
                contact19, contact20);
    }
}