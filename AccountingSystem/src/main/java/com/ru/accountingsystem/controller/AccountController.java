package com.ru.accountingsystem.controller;

import com.ru.accountingsystem.dto.edit.AccountEditDto;
import com.ru.accountingsystem.dto.read.AccountReadDto;
import com.ru.accountingsystem.service.AccountService;
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
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@GetMapping
	public List<AccountReadDto> findAll() {
		return accountService.findAll();
	}

	@GetMapping("{id}")
	public AccountReadDto findOne(@PathVariable Long id) {
		return accountService.findById(id);
	}

	@PostMapping
	public AccountReadDto create(@Validated @RequestBody AccountEditDto dto) {
		return accountService.create(dto);
	}

	@PutMapping("/{id}")
	public AccountReadDto edit(@PathVariable Long id, @Validated @RequestBody AccountEditDto dto) {
		return accountService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		accountService.delete(id);
	}

}
