package com.codingapi.persistence.jdbc.schema;

import com.codingapi.persistence.schema.Property;
import com.codingapi.persistence.schema.SaveSchema;
import com.codingapi.persistence.schema.Schema;

public class JdbcSaveSchema extends SaveSchema {

    public JdbcSaveSchema(Schema schema) {
        super(schema);
    }

    @Override
    public String saveSchema(boolean hasId) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(super.getSchemaName());
        sql.append(" (");
        for (Property property : super.getProperties(hasId)) {
            sql.append(property.getName());
            sql.append(", ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(") VALUES (");
        for (Property property : super.getProperties(hasId)) {
            sql.append("?, ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(")");
        return sql.toString();
    }


}
