package com.codingapi.persistence.schema;

public abstract class BuildSchema {

    public abstract String createSchema();

    protected final SchemaProperty property;

    public BuildSchema(Schema schema) {
        this.property = schema.getSchemaProperty();
    }
}
