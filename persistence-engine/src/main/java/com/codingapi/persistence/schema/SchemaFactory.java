package com.codingapi.persistence.schema;

public interface SchemaFactory {

    Schema getSchema(Class<?> domainClass);
}
