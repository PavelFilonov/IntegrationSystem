package com.ru.accountingsystem.controller;

import com.ru.accountingsystem.dto.edit.PurchaseEditDto;
import com.ru.accountingsystem.dto.read.PurchaseReadDto;
import com.ru.accountingsystem.service.PurchaseService;
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
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {

	private final PurchaseService purchaseService;

	@GetMapping
	public List<PurchaseReadDto> findAll() {
		return purchaseService.findAll();
	}

	@GetMapping("{id}")
	public PurchaseReadDto findOne(@PathVariable Long id) {
		return purchaseService.findById(id);
	}

	@PostMapping
	public PurchaseReadDto create(@Validated @RequestBody PurchaseEditDto dto) {
		return purchaseService.create(dto);
	}

	@PutMapping("/{id}")
	public PurchaseReadDto edit(@PathVariable Long id, @Validated @RequestBody PurchaseEditDto dto) {
		return purchaseService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		purchaseService.delete(id);
	}

}
