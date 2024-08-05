package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${web-app.url}")
	private String webAppUrl;

	public Requests getRequests() {
		return restTemplate.getForObject(webAppUrl + "/requests", Requests.class);
	}

}
