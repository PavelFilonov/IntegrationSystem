package com.ru.corporatedatastorage.rest;

import com.ru.corporatedatastorage.dto.read.Employees;
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

	public Employees getEmployees() {
		return restTemplate.getForObject(erpSystemUrl + "/employees", Employees.class);
	}

}
