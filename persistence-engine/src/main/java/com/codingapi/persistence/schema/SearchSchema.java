package com.codingapi.persistence.schema;

import lombok.Getter;
import org.yaml.snakeyaml.introspector.Property;

@Getter
public abstract class SearchSchema {

    private final String schemaName;

    private final Property idProperty;

    public SearchSchema(Schema schema) {
        this.schemaName = schema.getSchemaName();
        this.idProperty = schema.getIdProperty();
    }

    public abstract String getById();

    public Object getByIdValue(Object domain) {
        return idProperty.get(domain);
    }

}
