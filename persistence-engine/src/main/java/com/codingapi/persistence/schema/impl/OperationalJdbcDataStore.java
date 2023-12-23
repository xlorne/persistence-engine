package com.codingapi.persistence.schema.impl;

import com.codingapi.persistence.register.SchemaRegister;
import com.codingapi.persistence.schema.InsertSchema;
import com.codingapi.persistence.schema.OperationalDataStore;
import com.codingapi.persistence.schema.Schema;
import com.codingapi.persistence.schema.SearchSchema;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

@AllArgsConstructor
public class OperationalJdbcDataStore implements OperationalDataStore {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Object domain) {
        Schema schema = SchemaRegister.INSTANCE.supports(domain.getClass());
        if (schema != null) {
            InsertSchema insertSchema = schema.getInsertSchema();
            if(schema.hasIdValue(domain)) {
                jdbcTemplate.update(insertSchema.getInsertSql(), insertSchema.getInsertValue(domain));
            } else {
                KeyHolder keyHolder = new GeneratedKeyHolder();
                jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertSchema.getInsertSql(false), Statement.RETURN_GENERATED_KEYS);
                    int index = 1;
                    for(Object value : insertSchema.getInsertValue(domain,false)) {
                        ps.setObject(index++, value);
                    }
                    return ps;
                }, keyHolder);
                schema.setIdValue(domain, keyHolder.getKey());
            }
        }
    }

    @Override
    public <T> T get(Class<T> domainClass, Object id) {
        Schema schema = SchemaRegister.INSTANCE.supports(domainClass);
        if (schema != null) {
            SearchSchema searchSchema = schema.getById();
            String sql = searchSchema.getById();
            System.out.println(sql);
            try {
                return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(domainClass));
            } catch (EmptyResultDataAccessException e) {
                // Handle the case where no results are found or rethrow a custom exception
                return null;
            }
        }
        return null;
    }
}
