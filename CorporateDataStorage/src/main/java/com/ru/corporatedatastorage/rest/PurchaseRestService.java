package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Purchases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PurchaseRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${account-system.url}")
	private String accountSystemUrl;

	public Purchases getPurchases() {
		return restTemplate.getForObject(accountSystemUrl + "/purchases", Purchases.class);
	}

}
