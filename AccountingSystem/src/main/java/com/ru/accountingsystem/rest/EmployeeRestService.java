package com.ru.accountingsystem.rest;

import com.ru.accountingsystem.dto.read.EmployeeReadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${erp-system.url}")
	private String erpSystemUrl;

	public EmployeeReadDto getEmployeeById(Long id) {
		return restTemplate.getForObject(erpSystemUrl + "/employees/{id}", EmployeeReadDto.class, id);
	}

}
