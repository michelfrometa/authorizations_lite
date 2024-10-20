package com.test.authorizer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.test.authorizer.config.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AuthorizerApplicationTests {

	@Test
	void contextLoads() {
	}

}
