package com.codingapi.persistence.schema;

import lombok.Getter;

@Getter
public abstract class SearchSchema extends AbsSchema{

    public SearchSchema(Schema schema) {
       super(schema);
    }

    public abstract String getById();

    public Object getByIdValue(Object domain) {
        return getIdProperty().get(domain);
    }

}
