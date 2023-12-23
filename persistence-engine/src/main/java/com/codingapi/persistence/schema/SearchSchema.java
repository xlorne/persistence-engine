package com.codingapi.persistence.schema;

import org.yaml.snakeyaml.introspector.Property;

public class SearchSchema {

    private final String schemaName;

    private final Property idProperty;

    public SearchSchema(Schema schema) {
        this.schemaName = schema.getSchemaName();
        this.idProperty = schema.getIdProperty();
    }

    public String getById() {
        return "SELECT * FROM " + schemaName + " WHERE id = ?";
    }

    public Object getByIdValue(Object domain) {
        return idProperty.get(domain);
    }

}
