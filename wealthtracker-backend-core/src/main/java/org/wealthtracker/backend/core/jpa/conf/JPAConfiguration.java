package org.wealthtracker.backend.core.jpa.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.wealthtracker.backend.core.jpa.repository")
@EntityScan("org.wealthtracker.backend.core.jpa.entity")
public class JPAConfiguration {

}
