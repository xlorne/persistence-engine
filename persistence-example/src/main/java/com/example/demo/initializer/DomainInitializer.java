package com.example.demo.initializer;

import com.codingapi.persistence.register.SchemaRegister;
import com.example.demo.domain.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DomainInitializer implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        SchemaRegister.INSTANCE.register(Demo.class);
    }
}
