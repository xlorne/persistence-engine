package com.codingapi.persistence.schema;

import org.yaml.snakeyaml.introspector.Property;

import java.util.ArrayList;
import java.util.List;

public class InsertSchema {

    private final List<Property> properties;
    private final String schemaName;

    public InsertSchema(Schema schema) {
        this.properties = schema.getProperties();
        this.schemaName = schema.getSchemaName();
    }

    public String getInsertSql() {
        return getInsertSql(true);
    }

    public String getInsertSql(boolean hasId) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(schemaName);
        sql.append(" (");
        for (Property property : this.properties) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            sql.append(property.getName());
            sql.append(", ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(") VALUES (");
        for (Property property : this.properties) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            sql.append("?, ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(")");
        return sql.toString();
    }


    public Object[] getInsertValue(Object object, boolean hasId) {
        List<Object> values = new ArrayList<>();
        for (Property property : this.properties) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            values.add(property.get(object));
        }
        return values.toArray();
    }

    public Object[] getInsertValue(Object object) {
        return getInsertValue(object, true);
    }
}
