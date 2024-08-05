package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContractRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${account-system.url}")
	private String accountSystemUrl;

	public Contracts getContracts() {
		return restTemplate.getForObject(accountSystemUrl + "/contracts", Contracts.class);
	}

}
