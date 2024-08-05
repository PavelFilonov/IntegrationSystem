package com.ru.accountingsystem.service;

import static java.util.stream.Collectors.toList;

import com.ru.accountingsystem.dto.edit.ProductEditDto;
import com.ru.accountingsystem.dto.read.ProductReadDto;
import com.ru.accountingsystem.entity.Product;
import com.ru.accountingsystem.exception.EntityNotFoundException;
import com.ru.accountingsystem.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductService implements AbstractService<ProductReadDto, ProductEditDto, Product, Long> {

	private final ProductRepository productRepository;

	@Override
	public ProductReadDto create(ProductEditDto dto) {
		val entity = new Product();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public ProductReadDto update(Long id, ProductEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		productRepository.delete(entity);
	}

	@Override
	public ProductReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<ProductReadDto> findAll() {
		return productRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public ProductReadDto entityToDto(Product entity) {
		return new ProductReadDto(entity);
	}

	@Override
	public Product updateEntity(Product entity, ProductEditDto editDto) {
		entity.setName(editDto.getName());
		entity.setDescription(editDto.getDescription());
		entity.setPrice(editDto.getPrice());
		return productRepository.save(entity);
	}

	@Override
	public Product one(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class, id));
	}

}
