package com.codingapi.persistence.schema;

public interface OperationalDataStore {

    void save(Object domain);

    <T> T get(Class<T> domainClass, Object id);

}
