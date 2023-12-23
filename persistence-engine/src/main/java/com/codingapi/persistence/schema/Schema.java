package com.codingapi.persistence.schema;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Schema {

    @Getter
    private final Class<?> domainClass;
    @Getter
    private final List<Property> properties;
    @Getter
    private final Property idProperty;

    public Schema(Class<?> domainClass) {
        log.info("Schema init:{}", domainClass);
        this.domainClass = domainClass;

        PropertyUtils propertyUtils = new PropertyUtils();
        propertyUtils.setSkipMissingProperties(true);
        this.properties = new ArrayList<>(propertyUtils.getProperties(domainClass));
        this.idProperty = propertyUtils.getProperty(domainClass, "id");
    }

    public String getSchemaName() {
        return domainClass.getSimpleName();
    }


    public String getBuildSchema() {
        return "CREATE TABLE IF NOT EXISTS " + getSchemaName() + " (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100))";
    }


    public String getDropSchema() {
        return "DROP TABLE IF EXISTS " + getSchemaName();
    }

    public InsertSchema getInsertSchema() {
        return new InsertSchema(this);
    }

    public SearchSchema getById() {
        return new SearchSchema(this);
    }


    public boolean supports(Class<?> domainClass) {
        return this.domainClass.equals(domainClass);
    }


    public boolean hasIdValue(Object domain) {
        if (idProperty.getType().equals(int.class))
            return idProperty.get(domain) != null && (int) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(long.class))
            return idProperty.get(domain) != null && (long) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(double.class))
            return idProperty.get(domain) != null && (double) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(float.class))
            return idProperty.get(domain) != null && (float) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(short.class))
            return idProperty.get(domain) != null && (short) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(byte.class))
            return idProperty.get(domain) != null && (byte) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(boolean.class))
            return idProperty.get(domain) != null && (boolean) idProperty.get(domain);
        else if (idProperty.getType().equals(Integer.class))
            return idProperty.get(domain) != null && (Integer) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Long.class))
            return idProperty.get(domain) != null && (Long) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Double.class))
            return idProperty.get(domain) != null && (Double) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Float.class))
            return idProperty.get(domain) != null && (Float) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Short.class))
            return idProperty.get(domain) != null && (Short) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Byte.class))
            return idProperty.get(domain) != null && (Byte) idProperty.get(domain) > 0;
        else if (idProperty.getType().equals(Boolean.class))
            return idProperty.get(domain) != null && (Boolean) idProperty.get(domain);
        else if (idProperty.getType().equals(String.class))
            return idProperty.get(domain) != null && !((String) idProperty.get(domain)).isEmpty();
        else if (idProperty.getType().equals(Object.class))
            return idProperty.get(domain) != null;
        else
            throw new RuntimeException("not support type");
    }

    public void setIdValue(Object domain, Number key) {
        try {
            if (idProperty.getType().equals(int.class))
                idProperty.set(domain, key.intValue());
            else if (idProperty.getType().equals(long.class))
                idProperty.set(domain, key.longValue());
            else if (idProperty.getType().equals(double.class))
                idProperty.set(domain, key.doubleValue());
            else if (idProperty.getType().equals(float.class))
                idProperty.set(domain, key.floatValue());
            else if (idProperty.getType().equals(short.class))
                idProperty.set(domain, key.shortValue());
            else if (idProperty.getType().equals(byte.class))
                idProperty.set(domain, key.byteValue());
            else if (idProperty.getType().equals(boolean.class))
                idProperty.set(domain, key.byteValue());
            else if (idProperty.getType().equals(Integer.class))
                idProperty.set(domain, key.intValue());
            else if (idProperty.getType().equals(Long.class))
                idProperty.set(domain, key.longValue());
            else if (idProperty.getType().equals(Double.class))
                idProperty.set(domain, key.doubleValue());
            else if (idProperty.getType().equals(Float.class))
                idProperty.set(domain, key.floatValue());
            else if (idProperty.getType().equals(Short.class))
                idProperty.set(domain, key.shortValue());
            else if (idProperty.getType().equals(Byte.class))
                idProperty.set(domain, key.byteValue());
            else if (idProperty.getType().equals(Boolean.class))
                idProperty.set(domain, key.byteValue());
            else if (idProperty.getType().equals(String.class))
                idProperty.set(domain, key.toString());
            else if (idProperty.getType().equals(Object.class))
                idProperty.set(domain, key);
        } catch (Exception e) {
            log.error("setIdValue error", e);
        }
    }
}
