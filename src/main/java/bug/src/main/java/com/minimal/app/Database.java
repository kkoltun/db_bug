package com.minimal.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
  @Value("${db.sql.path}")
  private String sqlPath;

  @Value("${db.schema}")
  private String schema;

  @Bean
  public FlywayMigrationStrategy migrateStrategy() {
    return flyway -> {
      flyway.setSchemas(schema);
      flyway.setLocations(sqlPath);

      flyway.clean();
      flyway.migrate();
    };
  }
}
