package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Partners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PartnerRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${external-system.url}")
	private String externalSystemUrl;

	public Partners getPartners() {
		return restTemplate.getForObject(externalSystemUrl + "/partners", Partners.class);
	}

}
