package com.search.api.search;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}