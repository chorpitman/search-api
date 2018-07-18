package com.search.api.repository.impl;

import com.search.api.model.Contact;
import com.search.api.repository.CustomRepository;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
    private static final int BATCH_MAX_RESULT = 100;
    private static final int DEFAULT_PAGE_SIZE = 20;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contact> findContacts(final String regexp, final Integer nxtTokenPage) {
        if (Objects.isNull(nxtTokenPage)) {
            List<Contact> contact = getContact(regexp, 0);
            if (isContactHasDefaultPageSize(contact)) {
                return trimContactList(contact);
            }
            return contact;
        }

        List<Contact> contact = getContact(regexp, nxtTokenPage);
        if (isContactHasDefaultPageSize(contact)) {
            return trimContactList(contact);
        }
        return contact;
    }

    private List<Contact> getContact(final String regexp, int lastId) {
        List<Contact> resultList = new ArrayList<>(DEFAULT_PAGE_SIZE);
        boolean processing = true;
        while (processing) {
            List<Contact> contactList = getContactList(lastId);

            List<Contact> filteredList = contactList.stream()
                    .filter(contact -> contact.getName().matches(regexp))
                    .collect(Collectors.toList());

            resultList.addAll(filteredList);

            if (resultList.size() >= DEFAULT_PAGE_SIZE || contactList.size() < BATCH_MAX_RESULT) {
                processing = false;
            }

            lastId = contactList.get(contactList.size() - 1).getId();
        }

        return resultList;
    }

    private List<Contact> getContactList(final int lastId) {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("SELECT c FROM Contact as c WHERE c.id >:lastId order by c.id", Contact.class)
                .setParameter("lastId", lastId)
                .setReadOnly(true)
                .setCacheMode(CacheMode.IGNORE)
                .setMaxResults(BATCH_MAX_RESULT)
                .getResultList();
    }

    private boolean isContactHasDefaultPageSize(final List<Contact> contacts) {
        return contacts.size() > DEFAULT_PAGE_SIZE;
    }

    private List<Contact> trimContactList(final List<Contact> contactList) {
        return contactList.subList(0, DEFAULT_PAGE_SIZE);
    }
}
