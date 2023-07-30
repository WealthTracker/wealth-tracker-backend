package org.wealthtracker.backend.core.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wealthtracker.backend.core.jpa.entity.Asset;
import org.wealthtracker.backend.core.testutils.JPAConfiguration;

@Testcontainers
@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@Sql({"/sql/cleanup.sql",
    "/sql/populate.sql"
})
@ContextConfiguration(classes = JPAConfiguration.class)
class AssetRepositoryTest {

  @Container
  static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

  @Autowired
  AssetRepository assetRepository;

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
  }

  @Test
  void findById() {
    Asset asset = assetRepository.findById(1L).orElseThrow(RuntimeException::new);
  }

}