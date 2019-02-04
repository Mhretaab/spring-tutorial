package com.tutorial.spring.config;

import javax.sql.DataSource;

public interface DatabaseConfig {
 
    DataSource createDataSource();
     
}