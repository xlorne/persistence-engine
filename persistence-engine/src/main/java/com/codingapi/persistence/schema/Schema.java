package com.codingapi.persistence.schema;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
public abstract class Schema {

    private final Class<?> domainClass;
    private final List<Property> properties;
    private final Property idProperty;

    public Schema(Class<?> domainClass) {
        log.info("Schema init:{}", domainClass);
        this.domainClass = domainClass;

        PropertyUtils propertyUtils = new PropertyUtils();
        propertyUtils.setSkipMissingProperties(true);
        this.properties = propertyUtils.getProperties(domainClass).stream()
                .map(Property::new).collect(Collectors.toList());
        this.idProperty = new Property(propertyUtils.getProperty(domainClass, "id"));
    }

    public String getSchemaName() {
        return domainClass.getSimpleName();
    }


    public abstract BuildSchema buildSchema();

    public abstract SaveSchema insertSchema();

    public abstract SearchSchema getById();


    public boolean supports(Class<?> domainClass) {
        return this.domainClass.equals(domainClass);
    }


    public boolean hasIdValue(Object domain) {
        return idProperty.hasIdValue(domain);
    }

    public void setIdValue(Object domain, Number key) {
        idProperty.setIdValue(domain, key);
    }
}
