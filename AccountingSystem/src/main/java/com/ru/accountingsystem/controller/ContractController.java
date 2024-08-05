package com.ru.accountingsystem.controller;

import com.ru.accountingsystem.dto.edit.ContractEditDto;
import com.ru.accountingsystem.dto.read.ContractReadDto;
import com.ru.accountingsystem.service.ContractService;
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
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

	private final ContractService contractService;

	@GetMapping
	public List<ContractReadDto> findAll() {
		return contractService.findAll();
	}

	@GetMapping("{id}")
	public ContractReadDto findOne(@PathVariable Long id) {
		return contractService.findById(id);
	}

	@PostMapping
	public ContractReadDto create(@Validated @RequestBody ContractEditDto dto) {
		return contractService.create(dto);
	}

	@PutMapping("/{id}")
	public ContractReadDto edit(@PathVariable Long id, @Validated @RequestBody ContractEditDto dto) {
		return contractService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		contractService.delete(id);
	}

}
