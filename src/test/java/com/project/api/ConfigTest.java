package com.project.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import static org.mockito.Mockito.mock;

@Configuration
public class ConfigTest {
    @Bean
    public MBeanExporter exporter() {
        MBeanExporter exporter = mock(MBeanExporter.class);
        return exporter;
    }
}
