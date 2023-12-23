package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.schema.SaveSchema;
import com.codingapi.persistence.schema.Schema;
import org.yaml.snakeyaml.introspector.Property;

public class JdbcInsertSchema extends SaveSchema {

    public JdbcInsertSchema(Schema schema) {
        super(schema);
    }

    @Override
    public String saveSchema(boolean hasId) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(super.getSchemaName());
        sql.append(" (");
        for (Property property : super.getProperties()) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            sql.append(property.getName());
            sql.append(", ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(") VALUES (");
        for (Property property : super.getProperties()) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            sql.append("?, ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(")");
        return sql.toString();
    }


}
