package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Employee.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Employees;
import com.ru.corporatedatastorage.entity.Employee;
import com.ru.corporatedatastorage.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeHandler implements RestHandler<Employees> {

	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public void migrate(Employees dtoList) {
		val employeesDto = dtoList.getEmployees();
		if (employeesDto == null || employeesDto.isEmpty()) {
			return;
		}
		val employees = employeesDto.stream()
				.map(dto -> mapFromDto(employeeRepository.findByExternalId(dto.getId()).orElse(new Employee()), dto))
				.toList();
		employeeRepository.saveAllAndFlush(employees);
	}

}
