package com.search.api.service;


import com.search.api.model.Contact;

import java.util.Collection;

public interface ContactService {
    Collection<Contact> findContactByRegEx(final String name);
}