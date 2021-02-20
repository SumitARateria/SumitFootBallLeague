package com.football.league.position.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate(getClientHttpRequestFactory());
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= 
				new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setReadTimeout(5000);
		clientHttpRequestFactory.setConnectionRequestTimeout(3000);
		return clientHttpRequestFactory;
	}
}
