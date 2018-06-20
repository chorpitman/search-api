package com.search.api.search;

import lombok.Getter;

@Getter
public enum SqlOperation {
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE");

    final String name;

    SqlOperation(final String name) {
        this.name = name;
    }
}