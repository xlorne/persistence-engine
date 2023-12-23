package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SearchSchema;

public class JdbcSearchSchema extends SearchSchema {

    public JdbcSearchSchema(Schema schema) {
        super(schema);
    }

    @Override
    public String getById() {
        return "SELECT * FROM " + getSchemaName() + " WHERE id = ?";
    }


}
