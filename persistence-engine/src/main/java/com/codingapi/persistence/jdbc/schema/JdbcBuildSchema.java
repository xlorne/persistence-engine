package com.codingapi.persistence.jdbc.schema;

import com.codingapi.persistence.schema.BuildSchema;
import com.codingapi.persistence.schema.Property;
import com.codingapi.persistence.schema.Schema;

import java.util.List;

public class JdbcBuildSchema extends BuildSchema {

    public JdbcBuildSchema(Schema schema) {
        super(schema);
    }

    @Override
    public String createSchema() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS ");
        sql.append(getSchemaName());
        sql.append(" (");
        sql.append("id INT PRIMARY KEY AUTO_INCREMENT,");
        List<Property> properties = super.getProperties(false);
        for (int i = 0; i < properties.size(); i++) {
            Property property = properties.get(i);
            sql.append(property.getName());
            sql.append(" ");
            sql.append(property.getJdbcType());
            if (i != properties.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        return sql.toString();
    }
}
