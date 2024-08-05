package com.ru.externalservice.service;

import static java.util.stream.Collectors.toList;

import com.ru.externalservice.dto.edit.PartnerEditDto;
import com.ru.externalservice.dto.read.PartnerReadDto;
import com.ru.externalservice.entity.Partner;
import com.ru.externalservice.exception.EntityNotFoundException;
import com.ru.externalservice.repository.PartnerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerService implements AbstractService<PartnerReadDto, PartnerEditDto, Partner, Long> {

	private final PartnerRepository partnerRepository;

	@Override
	public PartnerReadDto create(PartnerEditDto dto) {
		val entity = new Partner();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public PartnerReadDto update(Long id, PartnerEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		partnerRepository.delete(entity);
	}

	@Override
	public PartnerReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<PartnerReadDto> findAll() {
		return partnerRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public PartnerReadDto entityToDto(Partner entity) {
		return new PartnerReadDto(entity);
	}

	@Override
	public Partner updateEntity(Partner entity, PartnerEditDto editDto) {
		entity.setAddress(editDto.getAddress());
		return partnerRepository.save(entity);
	}

	@Override
	public Partner one(Long id) {
		return partnerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Partner.class, id));
	}

}
