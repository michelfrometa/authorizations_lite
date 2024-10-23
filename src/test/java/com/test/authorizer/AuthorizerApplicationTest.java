package com.test.authorizer;

import com.test.authorizer.configuration.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AuthorizerApplicationTest {

	public static void main(String[] args) {
		SpringApplication.from(AuthorizerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

	@Test
	void contextLoads() {
	}

}
