package com.lightweight.internationaltime.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InternationalTimeAppConfiguration {
	
	@Value("${rest.template.connection.timeout}")
	private String connectionTimeout;
	
	@Value("${rest.template.read.timeout}")
	private String readTimeout;
	
	@Bean
	@Lazy
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder
                .setConnectTimeout(Duration.ofMillis(Integer.valueOf(connectionTimeout)))
                .setReadTimeout(Duration.ofMillis(Integer.valueOf(readTimeout)))
                .build();
	}
}
