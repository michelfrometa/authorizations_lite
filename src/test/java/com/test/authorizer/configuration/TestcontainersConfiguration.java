<<<<<<<< HEAD:src/test/java/com/test/authorizer/config/TestcontainersConfiguration.java
package com.test.authorizer.config;
========
package com.test.authorizer.configuration;
>>>>>>>> 0559e8f (test: Fix tests configuration and testcontainers visibility.):src/test/java/com/test/authorizer/configuration/TestcontainersConfiguration.java

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	MySQLContainer<?> mysqlContainer() {
		return new MySQLContainer<>(DockerImageName.parse("mysql:5.7")) // TODO Externalize the mysql version to use the
																		// same everywhere
				.withReuse(true);
	}

}
