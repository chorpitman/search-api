package com.search.api.repository;

import com.search.api.model.Contact;

import java.util.List;

public interface CustomRepository {

    List<Contact> findWithStream(final String regexp, final Integer nxtTokenPage);
}
