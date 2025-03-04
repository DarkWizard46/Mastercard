package com.mastercard.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:other.properties")
public class OtherConfig {
    @Getter
    private static String flagLogging;

    @Value("${flag.logging}")
    private void setFlagLogging(String flagLogging) {
        OtherConfig.flagLogging = flagLogging;
    }
}
