package com.codingapi.persistence.jdbc.schema;

import com.codingapi.persistence.schema.BuildSchema;
import com.codingapi.persistence.schema.SaveSchema;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SearchSchema;

public class JdbcSchema extends Schema {

    public JdbcSchema(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    public BuildSchema buildSchema() {
        return new JdbcBuildSchema(this);
    }

    @Override
    public SaveSchema insertSchema() {
        return new JdbcSaveSchema(this);
    }

    @Override
    public SearchSchema getById() {
        return new JdbcSearchSchema(this);
    }
}
