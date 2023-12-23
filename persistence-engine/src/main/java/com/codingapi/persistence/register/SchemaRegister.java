package com.codingapi.persistence.register;

import com.codingapi.persistence.schema.Schema;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SchemaRegister {

    private final List<Schema> schemas;

    public final static SchemaRegister INSTANCE = new SchemaRegister();

    private SchemaRegister() {
        this.schemas = new ArrayList<>();
    }

    public void register(Class<?> domainClass) {
        this.schemas.add(new Schema(domainClass));
    }

    public Schema supports(Class<?> domainClass) {
        return this.schemas.stream()
                .filter(schema -> schema.supports(domainClass))
                .findFirst()
                .orElse(null);
    }

}
