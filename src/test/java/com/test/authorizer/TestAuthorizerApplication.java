package com.test.authorizer;

import org.springframework.boot.SpringApplication;

import com.test.authorizer.configuration.TestcontainersConfiguration;

public class TestAuthorizerApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthorizerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
