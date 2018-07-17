package com.search.api.controller;

import com.search.api.model.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactDto {
    private List<Contact> contacts;
    private int pageToken;
}
