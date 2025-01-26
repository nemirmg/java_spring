package ru.gb.crud_spring_web.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="sql")
public class SQLConfig {
    private String findAll;
    private String save;
    private String deleteById;
    private String update;
    private String findById;
}
