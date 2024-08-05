package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${account-system.url}")
	private String accountSystemUrl;

	public Products getProducts() {
		return restTemplate.getForObject(accountSystemUrl + "/products", Products.class);
	}

}
