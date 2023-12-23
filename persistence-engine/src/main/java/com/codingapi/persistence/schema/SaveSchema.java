package com.codingapi.persistence.schema;

import lombok.Getter;
import org.yaml.snakeyaml.introspector.Property;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class SaveSchema {

    private final List<Property> properties;
    private final String schemaName;

    public SaveSchema(Schema schema) {
        this.properties = schema.getProperties();
        this.schemaName = schema.getSchemaName();
    }

    public String saveSchema() {
        return saveSchema(true);
    }

    public abstract String saveSchema(boolean hasId);


    public Object[] getSaveValues(Object object, boolean hasId) {
        List<Object> values = new ArrayList<>();
        for (Property property : this.properties) {
            if (hasId && property.getName().equals("id")) {
                continue;
            }
            values.add(property.get(object));
        }
        return values.toArray();
    }

    public Object[] getSaveValues(Object object) {
        return getSaveValues(object, true);
    }
}
