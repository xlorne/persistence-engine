package com.codingapi.persistence;

import com.codingapi.persistence.scanner.DomainScanner;
import com.codingapi.persistence.schema.OperationalDataStore;
import com.codingapi.persistence.schema.SchemaExecutor;
import com.codingapi.persistence.schema.impl.OperationalJdbcDataStore;
import com.codingapi.persistence.schema.impl.SchemaJdbcExecutor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@Configurable
public class AutoConfiguration {

    @Bean
    public SchemaExecutor schemaExecutor(JdbcTemplate jdbcTemplate) {
        return new SchemaJdbcExecutor(jdbcTemplate);
    }

    @Bean
    public OperationalDataStore operationalDataStore(JdbcTemplate jdbcTemplate) {
        return new OperationalJdbcDataStore(jdbcTemplate);
    }

    @Bean
    public DomainScanner domainScanner(SchemaExecutor schemaExecutor) {
        return new DomainScanner(schemaExecutor);
    }

}
