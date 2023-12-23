package com.codingapi.persistence.scanner;

import com.codingapi.persistence.register.DomainRegister;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SchemaExecutor;
import com.codingapi.persistence.schema.SchemaFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

@Slf4j
public class SchemaScanner implements ApplicationRunner {

    private final SchemaExecutor schemaExecutor;

    private final SchemaFactory schemaFactory;

    public SchemaScanner(SchemaExecutor schemaExecutor, SchemaFactory schemaFactory) {
        this.schemaExecutor = schemaExecutor;
        this.schemaFactory = schemaFactory;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Class<?>> domainClasses = DomainRegister.INSTANCE.getClasses();
        for (Class<?> domainClass : domainClasses) {
            Schema schema = schemaFactory.getSchema(domainClass);
            SchemaContext.INSTANCE.register(schema);
            schemaExecutor.create(schema);
        }
    }

}
