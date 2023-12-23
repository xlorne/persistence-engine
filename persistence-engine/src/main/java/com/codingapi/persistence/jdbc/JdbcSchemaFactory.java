package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.jdbc.schema.JdbcSchema;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SchemaFactory;

public class JdbcSchemaFactory implements SchemaFactory {

    @Override
    public Schema getSchema(Class<?> domainClass) {
        return new JdbcSchema(domainClass);
    }

}
