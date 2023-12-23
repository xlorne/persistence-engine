package com.codingapi.persistence.jdbc;

import com.codingapi.persistence.scanner.SchemaContext;
import com.codingapi.persistence.schema.SaveSchema;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SchemaExecutor;
import com.codingapi.persistence.schema.SearchSchema;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@AllArgsConstructor
public class JdbcSchemaExecutor implements SchemaExecutor {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void create(Schema schema) {
        jdbcTemplate.execute(schema.createSchema());
    }


}
