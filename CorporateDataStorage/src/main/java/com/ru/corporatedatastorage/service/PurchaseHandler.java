package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Purchase.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Purchases;
import com.ru.corporatedatastorage.entity.Purchase;
import com.ru.corporatedatastorage.repository.EmployeeRepository;
import com.ru.corporatedatastorage.repository.ProductRepository;
import com.ru.corporatedatastorage.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseHandler implements RestHandler<Purchases> {

	private final PurchaseRepository purchaseRepository;

	private final ProductRepository productRepository;

	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public void migrate(Purchases dtoList) {
		val purchasesDto = dtoList.getPurchases();
		if (purchasesDto == null || purchasesDto.isEmpty()) {
			return;
		}
		val purchases = purchasesDto.stream()
				.map(dto -> {
					val entity = mapFromDto(purchaseRepository.findByExternalId(dto.getId()).orElse(new Purchase()), dto);
					entity.setProduct(productRepository.findById(dto.getProduct().getId()).orElseThrow());
					entity.setEmployee(employeeRepository.findById(dto.getEmployee().getId()).orElseThrow());
					return entity;
				})
				.toList();
		purchaseRepository.saveAllAndFlush(purchases);
	}

}
