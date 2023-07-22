package org.wealthtracker.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWealthtrackerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(WealthtrackerRestApiApplication::main).with(TestWealthtrackerRestApiApplication.class).run(args);
	}

}
