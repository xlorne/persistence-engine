package com.codingapi.persistence.scanner;

import com.codingapi.persistence.register.SchemaRegister;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SchemaExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class DomainScanner implements ApplicationRunner {

    private final SchemaExecutor schemaExecutor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Schema> schemas = SchemaRegister.INSTANCE.getSchemas();
        for (Schema schema : schemas) {
            schemaExecutor.create(schema);
        }
    }
}
