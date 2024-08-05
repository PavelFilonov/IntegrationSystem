package com.ru.accountingsystem.service;

import static java.util.stream.Collectors.toList;

import com.ru.accountingsystem.dto.edit.PurchaseEditDto;
import com.ru.accountingsystem.dto.read.PurchaseReadDto;
import com.ru.accountingsystem.entity.Employee;
import com.ru.accountingsystem.entity.Purchase;
import com.ru.accountingsystem.exception.EntityNotFoundException;
import com.ru.accountingsystem.repository.ProductRepository;
import com.ru.accountingsystem.repository.PurchaseRepository;
import com.ru.accountingsystem.rest.EmployeeRestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseService implements AbstractService<PurchaseReadDto, PurchaseEditDto, Purchase, Long> {

	private final PurchaseRepository purchaseRepository;

	private final ProductRepository productRepository;

	private final EmployeeRestService employeeRestService;

	@Override
	public PurchaseReadDto create(PurchaseEditDto dto) {
		val entity = new Purchase();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public PurchaseReadDto update(Long id, PurchaseEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		purchaseRepository.delete(entity);
	}

	@Override
	public PurchaseReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<PurchaseReadDto> findAll() {
		return purchaseRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public PurchaseReadDto entityToDto(Purchase entity) {
		val dto = new PurchaseReadDto(entity);
		dto.setEmployee(employeeRestService.getEmployeeById(entity.getEmployeeId()));
		return dto;
	}

	@Override
	public Purchase updateEntity(Purchase entity, PurchaseEditDto editDto) {
		entity.setProduct(productRepository.findById(editDto.getProductId()).orElseThrow());
		Long employeeId = editDto.getEmployeeId();
		try {
			entity.setEmployeeId(employeeRestService.getEmployeeById(employeeId).getId());
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException(Employee.class, employeeId);
		}
		entity.setPurchasedAt(editDto.getPurchasedAt());
		return purchaseRepository.save(entity);
	}

	@Override
	public Purchase one(Long id) {
		return purchaseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Purchase.class, id));
	}

}
