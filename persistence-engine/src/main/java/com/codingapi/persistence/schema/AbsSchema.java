package com.codingapi.persistence.schema;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


public abstract class AbsSchema {

    private final List<Property> properties;
    @Getter
    private final String schemaName;
    @Getter
    private final Property idProperty;

    public AbsSchema(Schema schema) {
        this.properties = schema.getProperties();
        this.schemaName = schema.getSchemaName();
        this.idProperty = schema.getIdProperty();
    }


    public List<Property> getProperties(boolean hasId) {
        if(hasId){
            return properties;
        }else{
            return properties.stream()
                    .filter(property -> !property.getName().equals("id"))
                    .collect(Collectors.toList());
        }
    }

    public List<Property> getProperties() {
        return getProperties(true);
    }
}
