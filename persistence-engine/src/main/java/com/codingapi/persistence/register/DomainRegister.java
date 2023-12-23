package com.codingapi.persistence.register;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DomainRegister {

    private final List<Class<?>> classes;

    public final static DomainRegister INSTANCE = new DomainRegister();

    private DomainRegister() {
        this.classes = new ArrayList<>();
    }

    public void register(Class<?> domainClass) {
        this.classes.add(domainClass);
    }

    public boolean supports(Class<?> domainClass) {
        return this.classes.stream()
                .anyMatch(clazz -> clazz.equals(domainClass));

    }

}
