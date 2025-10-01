package com.pg_management.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
class ServerApplicationTests {

  @Test
  void contextLoads() {}
}
