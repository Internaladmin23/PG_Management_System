package com.pg_management.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
    static class TestConfiguration {
    }

    @Test
    void contextLoads() {}
}

