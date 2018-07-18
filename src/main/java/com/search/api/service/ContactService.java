package com.search.api.service;


import com.search.api.controller.PageDto;

public interface ContactService {

    PageDto findContactsByReqExp(final String name, final Integer nextTokenPage);
}