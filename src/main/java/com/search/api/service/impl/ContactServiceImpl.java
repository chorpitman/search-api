package com.search.api.service.impl;


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

//    @Override
//    public Collection<Contact> findContactByRegEx(final String regex) {
//        LOGGER.debug("About process: get contacts by filter phrase: {}", regex);
//        if (Objects.isNull(regex)) {
//            return Collections.emptyList();
//        }
//
//        List<Contact> contacts = contactRepository.findAll();
//
//        List<Contact> matchedContacts = new ArrayList<>();
//        for (Contact contact : contacts) {
//            if (!Pattern.compile(regex).matcher(contact.getName()).find()) {
//                matchedContacts.add(contact);
//            }
//        }
//
//        if (matchedContacts.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        return matchedContacts;
//    }

//    @Override
//    public Collection<Contact> findContactByScrollableResult(final String name) {
//        return contactRepository.findContactsWithScrollable(name);
//    }

    @Override
    public List<Contact> findByStream(final String name, final Integer nextTokenPage) {
        return contactRepository.findWithStream(name, nextTokenPage);
    }
}