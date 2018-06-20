package com.search.api.search;


import com.search.api.model.Contact;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Setter
@Getter
public class ContactSpecification implements Specification<Contact> {
    private SearchCriteria criteria;

    public ContactSpecification(SearchCriteria searchCriteria) {
        super();
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(final Root<Contact> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
        String key = criteria.getKey();
        String operation = criteria.getOperation();
        Object value = criteria.getValue();

        Predicate like = cb.notLike(root.get(criteria.getKey()), "%" + criteria.getValue().toString() + "%");

        return like;
    }
}