package com.ru.erpsystem.controller;

import com.ru.erpsystem.dto.edit.EmployeeEditDto;
import com.ru.erpsystem.dto.read.EmployeeReadDto;
import com.ru.erpsystem.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping
	public List<EmployeeReadDto> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("{id}")
	public EmployeeReadDto findOne(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@PostMapping
	public EmployeeReadDto create(@Validated @RequestBody EmployeeEditDto dto) {
		return employeeService.create(dto);
	}

	@PutMapping("/{id}")
	public EmployeeReadDto edit(@PathVariable Long id, @Validated @RequestBody EmployeeEditDto dto) {
		return employeeService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}

}
