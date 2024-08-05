package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${account-system.url}")
	private String accountSystemUrl;

	public Accounts getAccounts() {
		return restTemplate.getForObject(accountSystemUrl + "/accounts", Accounts.class);
	}

}
