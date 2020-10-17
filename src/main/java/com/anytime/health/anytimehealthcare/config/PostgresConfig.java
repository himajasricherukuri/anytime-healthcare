package com.anytime.health.anytimehealthcare.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("local")
public class PostgresConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.hikari.connection-test-query}")
    private String connectionTestQuery;

    @Value("${spring.datasource.hikari.username}")
    private String username;

    @Value("${spring.datasource.hikari.password}")
    private String password;

    @Bean(name = "datasource")
    public DataSource dataSource() {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driverClass);
        ds.setConnectionTestQuery(connectionTestQuery);
        ds.setMinimumIdle(0);
        ds.setMaximumPoolSize(25);

        return ds;
    }
}
