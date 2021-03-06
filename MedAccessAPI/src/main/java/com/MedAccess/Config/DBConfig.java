/*
package com.MedAccess.Config;


import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig {

        @Autowired
        private Environment env;
        @Bean
        public DataSource getDataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
            dataSource.setUrl(env.getProperty("database.url"));
            dataSource.setUsername(env.getProperty("database.username"));
            dataSource.setPassword(env.getProperty("database.password"));
            return dataSource;
        }
        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(getDataSource());
        }
        @Bean(name="transactionManager")
        public PlatformTransactionManager txManager() {
            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(getDataSource());
            return transactionManager;
        }
    }


*/