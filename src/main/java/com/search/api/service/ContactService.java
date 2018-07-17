package com.search.api.service;


import com.search.api.model.Contact;

import java.util.List;

public interface ContactService {
//    Collection<Contact> findContactByRegEx(final String name);

//    Collection<Contact> findContactByScrollableResult(final String name);

    List<Contact> findByStream(final String name, final Integer nextTokenPage);

}