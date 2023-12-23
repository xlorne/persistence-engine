package com.codingapi.persistence.schema;

public abstract class BuildSchema extends AbsSchema {

    public BuildSchema(Schema schema) {
        super(schema);
    }

    public abstract String createSchema();
}
