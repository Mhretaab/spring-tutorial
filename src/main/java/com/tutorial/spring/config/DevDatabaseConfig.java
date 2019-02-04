package com.tutorial.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/*
 *Setting spring.profiles.active property (via JVM arguments, environment variable or Servlet context parameter in web.xml in case of web applications)
ApplicationContext.getEnvironment().setActiveProfiles(“ProfileName”);
 */

@Profile("Development")
@Configuration
public class DevDatabaseConfig implements DatabaseConfig {
 
    @Override
    @Bean
    public DataSource createDataSource() {
        System.out.println("Creating DEV database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        /*
         * Set MySQL specific properties for Development Environment
         */
        return dataSource;
    }
 
}