package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Product.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Products;
import com.ru.corporatedatastorage.entity.Product;
import com.ru.corporatedatastorage.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductHandler implements RestHandler<Products> {

	private final ProductRepository productRepository;

	@Override
	@Transactional
	public void migrate(Products dtoList) {
		val productsDto = dtoList.getProducts();
		if (productsDto == null || productsDto.isEmpty()) {
			return;
		}
		val products = productsDto.stream()
				.map(dto -> mapFromDto(productRepository.findByExternalId(dto.getId()).orElse(new Product()), dto))
				.toList();
		productRepository.saveAllAndFlush(products);
	}

}
