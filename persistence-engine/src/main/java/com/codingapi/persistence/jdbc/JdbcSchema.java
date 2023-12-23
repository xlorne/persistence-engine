package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.schema.SaveSchema;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SearchSchema;

public class JdbcSchema extends Schema {

    public JdbcSchema(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    public String createSchema() {
        return "CREATE TABLE IF NOT EXISTS " + getSchemaName() + " (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100))";
    }

    @Override
    public SaveSchema insertSchema() {
        return new JdbcInsertSchema(this);
    }

    @Override
    public SearchSchema getById() {
        return new JdbcSearchSchema(this);
    }
}
