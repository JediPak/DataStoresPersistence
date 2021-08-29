package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
   @Bean
   @ConfigurationProperties("spring.datasource")
   //jdbc:mysql://localhost:3306/plantdb
   public DataSource getDatasource() {
      DataSourceBuilder dsb = DataSourceBuilder.create();
      dsb.username("jay");
      dsb.password(securePasswordService());
      dsb.url("jdbc:mysql://localhost:3306/plantdb");
      return dsb.build();
   }

   private String securePasswordService() {
      return "jay1234";
   }
}
