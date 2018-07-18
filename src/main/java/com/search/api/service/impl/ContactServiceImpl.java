package com.search.api.service.impl;


import com.search.api.controller.PageDto;
import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import com.search.api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public PageDto findContactsByReqExp(final String name, final Integer nextTokenPage) {
        List<Contact> foundContacts = contactRepository.findContacts(name, nextTokenPage);
        return createPageDto(foundContacts);
    }

    private PageDto createPageDto(final List<Contact> contactList) {
        if (contactList.size() <= DEFAULT_PAGE_SIZE) {
            return PageDto.builder()
                    .contacts(contactList)
                    .pageToken(contactList.get(contactList.size() - 1).getId())
                    .build();
        }

        if (contactList.size() > DEFAULT_PAGE_SIZE) {
            List<Contact> trimedList = trimContact(contactList);
            return PageDto.builder()
                    .contacts(trimedList)
                    .pageToken(trimedList.get(trimedList.size() - 1).getId())
                    .build();
        }

        return null;
    }

    private List<Contact> trimContact(final List<Contact> contactList) {
        return contactList.subList(1, DEFAULT_PAGE_SIZE);
    }
}