package com.ru.accountingsystem.service;

import static java.util.stream.Collectors.toList;

import com.ru.accountingsystem.dto.edit.ContractEditDto;
import com.ru.accountingsystem.dto.read.ContractReadDto;
import com.ru.accountingsystem.entity.Contract;
import com.ru.accountingsystem.entity.Partner;
import com.ru.accountingsystem.exception.EntityNotFoundException;
import com.ru.accountingsystem.repository.ContractRepository;
import com.ru.accountingsystem.rest.PartnerRestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractService implements AbstractService<ContractReadDto, ContractEditDto, Contract, Long> {

	private final ContractRepository contractRepository;

	private final PartnerRestService partnerRestService;

	@Override
	public ContractReadDto create(ContractEditDto dto) {
		val entity = new Contract();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public ContractReadDto update(Long id, ContractEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		contractRepository.delete(entity);
	}

	@Override
	public ContractReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<ContractReadDto> findAll() {
		return contractRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public ContractReadDto entityToDto(Contract entity) {
		val dto = new ContractReadDto(entity);
		dto.setPartner(partnerRestService.getPartnerById(entity.getPartnerId()));
		return dto;
	}

	@Override
	public Contract updateEntity(Contract entity, ContractEditDto editDto) {
		entity.setText(editDto.getText());
		entity.setEffectiveFrom(editDto.getEffectiveFrom());
		entity.setEffectiveTo(editDto.getEffectiveTo());
		Long partnerId = editDto.getPartnerId();
		try {
			entity.setPartnerId(partnerRestService.getPartnerById(partnerId).getId());
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException(Partner.class, partnerId);
		}
		return contractRepository.save(entity);
	}

	@Override
	public Contract one(Long id) {
		return contractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Contract.class, id));
	}

}
