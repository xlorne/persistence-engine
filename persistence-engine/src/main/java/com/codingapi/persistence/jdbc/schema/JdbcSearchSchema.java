package com.codingapi.persistence.jdbc.schema;

import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SearchSchema;

public class JdbcSearchSchema extends SearchSchema {

    public JdbcSearchSchema(Schema schema) {
        super(schema);
    }

    @Override
    public String getById() {
        return "SELECT * FROM " + property.getSchemaName() + " WHERE id = ?";
    }


}
