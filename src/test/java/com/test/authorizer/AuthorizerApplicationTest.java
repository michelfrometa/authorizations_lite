package com.test.authorizer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.test.authorizer.configuration.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AuthorizerApplicationTest {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		SpringApplication.from(AuthorizerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
