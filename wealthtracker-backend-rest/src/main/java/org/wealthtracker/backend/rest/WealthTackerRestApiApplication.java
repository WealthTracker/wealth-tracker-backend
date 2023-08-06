package org.wealthtracker.backend.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.wealthtracker.backend.rest",
    "org.wealthtracker.backend.core"})
public class WealthTackerRestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(WealthTackerRestApiApplication.class, args);
  }

}
