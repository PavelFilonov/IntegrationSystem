package com.ru.accountingsystem.rest;

import com.ru.accountingsystem.dto.read.PartnerReadDto;
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

	public PartnerReadDto getPartnerById(Long id) {
		return restTemplate.getForObject(externalSystemUrl + "/partners/{id}", PartnerReadDto.class, id);
	}

}
