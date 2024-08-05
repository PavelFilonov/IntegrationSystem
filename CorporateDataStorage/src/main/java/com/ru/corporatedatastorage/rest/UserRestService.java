package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${web-app.url}")
	private String webAppUrl;

	public Users getUsers() {
		return restTemplate.getForObject(webAppUrl + "/users", Users.class);
	}

}
