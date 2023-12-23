package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.DomainPersistence;
import com.codingapi.persistence.schema.SchemaExecutor;
import com.codingapi.persistence.schema.SchemaFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@Configurable
public class JdbcAutoConfiguration {

    @Bean
    public SchemaExecutor schemaExecutor(JdbcTemplate jdbcTemplate) {
        return new JdbcSchemaExecutor(jdbcTemplate);
    }

    @Bean
    public DomainPersistence domainPersistence(JdbcTemplate jdbcTemplate) {
        return new JdbcDomainPersistence(jdbcTemplate);
    }

    @Bean
    public SchemaFactory schemaFactory() {
        return new JdbcSchemaFactory();
    }
}
