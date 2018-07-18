package com.search.api.service.impl;


import com.search.api.controller.dto.PageDto;
import com.search.api.model.Contact;
import com.search.api.repository.ContactRepository;
import com.search.api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public PageDto findContactsByReqExp(final String name, final Integer nextTokenPage) {
        List<Contact> foundContacts = contactRepository.findContacts(name, nextTokenPage);
        return createPageDto(foundContacts);
    }

    private PageDto createPageDto(final List<Contact> contactList) {
        if (contactList.size() != 0) {
            return PageDto.builder()
                    .contacts(contactList)
                    .pageToken(contactList.get(contactList.size() - 1).getId())
                    .build();
        }
        return null;
    }

}