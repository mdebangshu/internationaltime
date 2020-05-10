package com.lightweight.internationaltime.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lightweight.internationaltime.model.WorldTime;

@Component
public class WorldTimeAdapter {
	
	@Value("${aws.weather.gateway.url}")
	private String gatewayUrl;

	@Autowired
	private RestTemplate restTemplate;

	public WorldTime getWorldTime(String county) {
		ResponseEntity<WorldTime> responseEntity = restTemplate
				.getForEntity(gatewayUrl + county, WorldTime.class);
		return responseEntity.getBody();
	}
}