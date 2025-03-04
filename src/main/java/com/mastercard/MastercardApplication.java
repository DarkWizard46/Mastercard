package com.mastercard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mastercard.repository")
@EntityScan(basePackages = "com.mastercard.model")
public class MastercardApplication {
    public static void main(String[] args) {
        SpringApplication.run(MastercardApplication.class, args);
    }
}
