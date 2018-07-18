package com.search.api.controller;

import com.search.api.controller.dto.PageDto;
import com.search.api.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/hello")
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts/page/{nextPageToken}/", method = RequestMethod.GET)
    public ResponseEntity<PageDto> getContacts(@RequestParam(name = "nameFilter") final String regexp,
                                               @PathVariable(name = "nextPageToken") final Integer nextPageToken) {
        LOGGER.debug("About process: get contacts by filter phrase: '{}'. Next page token '{}'.", regexp, nextPageToken);
        PageDto contactsPageDto = contactService.findContactsByReqExp(regexp, nextPageToken);
        if (Objects.isNull(contactsPageDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(contactsPageDto);
    }
}