package com.codingapi.persistence;

import com.codingapi.persistence.scanner.SchemaScanner;
import com.codingapi.persistence.schema.SchemaExecutor;
import com.codingapi.persistence.schema.SchemaFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AutoConfiguration {

    @Bean
    public SchemaScanner domainScanner(SchemaExecutor schemaExecutor, SchemaFactory schemaFactory) {
        return new SchemaScanner(schemaExecutor, schemaFactory);
    }

}
