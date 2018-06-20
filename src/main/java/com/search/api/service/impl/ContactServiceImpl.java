package com.search.api.service.impl;


import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import com.search.api.search.ContactSpecification;
import com.search.api.search.SearchCriteria;
import com.search.api.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.search.api.search.SqlOperation.LIKE;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Collection<Contact> findContactByName(final String filterPhrase) {
        SearchCriteria name = new SearchCriteria("name", LIKE.name(), filterPhrase);
        ContactSpecification specifications = new ContactSpecification(name);
        List<Contact> contactList = contactRepository.findAll(specifications);

        return contactList;
    }
}