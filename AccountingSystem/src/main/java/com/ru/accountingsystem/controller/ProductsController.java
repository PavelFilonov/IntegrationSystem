package com.ru.accountingsystem.controller;

import com.ru.accountingsystem.dto.edit.ProductEditDto;
import com.ru.accountingsystem.dto.read.ProductReadDto;
import com.ru.accountingsystem.service.ProductService;
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
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

	private final ProductService productService;

	@GetMapping
	public List<ProductReadDto> findAll() {
		return productService.findAll();
	}

	@GetMapping("{id}")
	public ProductReadDto findOne(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PostMapping
	public ProductReadDto create(@Validated @RequestBody ProductEditDto dto) {
		return productService.create(dto);
	}

	@PutMapping("/{id}")
	public ProductReadDto edit(@PathVariable Long id, @Validated @RequestBody ProductEditDto dto) {
		return productService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}

}
