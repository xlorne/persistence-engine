package com.codingapi.persistence.schema;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class SaveSchema extends AbsSchema {

    public SaveSchema(Schema schema) {
        super(schema);
    }

    public String saveSchema() {
        return saveSchema(true);
    }

    public abstract String saveSchema(boolean hasId);


    public Object[] getSaveValues(Object object, boolean hasId) {
        List<Object> values = new ArrayList<>();
        for (Property property : getProperties(hasId)) {
            values.add(property.get(object));
        }
        return values.toArray();
    }

    public Object[] getSaveValues(Object object) {
        return getSaveValues(object, true);
    }
}
