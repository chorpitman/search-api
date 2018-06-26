package com.search.api.service.impl;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import com.search.api.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Collection<Contact> findContactByRegEx(final String regex) {
        LOGGER.debug("About process: get contacts by filter phrase: {}", regex);
        if (Objects.isNull(regex)) {
            return Collections.emptyList();
        }

        //get all contacts
        List<Contact> contacts = contactRepository.findAll(Sort.by("name").ascending());

        //prepare list for matched Contacts
        List<Contact> matchedContacts = contacts
                .stream()
                .filter(contact -> Pattern.compile(regex).matcher(contact.getName()).find())
                .collect(Collectors.toList());

        if (matchedContacts.isEmpty()) {
            return Collections.emptyList();
        }

        return matchedContacts;
    }
}