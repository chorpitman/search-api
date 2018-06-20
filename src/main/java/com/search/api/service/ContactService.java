package com.search.api.service;


import com.search.api.model.Contact;

import java.util.Collection;

public interface ContactService {
    Collection<Contact> findContactByName(final String name);
}