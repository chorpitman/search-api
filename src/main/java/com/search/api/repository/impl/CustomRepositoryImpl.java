package com.search.api.repository.impl;

import com.search.api.model.Contact;
import com.search.api.repository.CustomRepository;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
    private static final int BATCH_MAX_RESULT = 100;
    private static final int BATCH_FETCH_SIZE = 20;

    private static final int DEFAULT_PAGE_SIZE = 20;

    private static final String QUERY = "SELECT c FROM Contact as c where c.id:";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contact> findWithStream(final String regexp, final Integer nxtTokenPage) {
        List<Contact> contactList = getContact(regexp, nxtTokenPage, nxtTokenPage.toString());

        if (contactList.isEmpty()) {
            return null;

        }

        if (contactList.size() == DEFAULT_PAGE_SIZE) {
            return contactList;
        }
        //todo check default page size.
        if (contactList.size() < DEFAULT_PAGE_SIZE) {
            return null;
        }

        if (contactList.size() > DEFAULT_PAGE_SIZE) {
            List<Contact> trimedContacts = trimRedundantElement(contactList);
        }

        return null;
    }

    private List<Contact> getContact(final String regexp, int startPosition, String lastId) {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("SELECT c FROM Contact as c WHERE c.id:" + lastId, Contact.class)
                .setReadOnly(true)
                .setCacheMode(CacheMode.IGNORE)
//                .setFirstResult()
                .setMaxResults(BATCH_MAX_RESULT)
                .setFetchSize(BATCH_FETCH_SIZE)
                .getResultList()
                .stream()
                .filter(contact -> contact.getName().matches(regexp))
                .collect(Collectors.toList());
    }

    private List<Contact> trimRedundantElement(final List<Contact> contacts) {
        return contacts.subList(0, CustomRepositoryImpl.DEFAULT_PAGE_SIZE);
    }

//    private ContactDto createDto(final List<Contact> contactList, final List<Contact> contacts) {
//        ContactDto dto = new ContactDto();
//        dto.setContacts(contacts);
//        dto.setPageToken(contactList.lastIndexOf(contacts.get(contacts.size() - 1)));
//
//        return dto;
//    }
}
