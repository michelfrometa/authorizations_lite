package com.test.authorizer;

import com.test.authorizer.configuration.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AuthorizerApplicationTest {

	@Test
	void contextLoads() {
	}

}
