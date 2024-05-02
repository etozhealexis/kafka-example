package com.example.producer.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

@Configuration
@EnableAutoConfiguration(exclude = {
        JmxAutoConfiguration.class
})
public class MetricsConfig {

    @Bean
    public MemoryMXBean memoryMXBean() {
        return ManagementFactory.getMemoryMXBean();
    }

    @Bean
    public ThreadMXBean threadMXBean() {
        return ManagementFactory.getThreadMXBean();
    }
}
