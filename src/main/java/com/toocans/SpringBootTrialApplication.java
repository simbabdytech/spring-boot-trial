package com.toocans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootTrialApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTrialApplication.class, args);
    }
}
