package com.search.api.controller.dto;

import com.search.api.model.Contact;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageDto {
    private List<Contact> contacts;
    private int pageToken;
}
