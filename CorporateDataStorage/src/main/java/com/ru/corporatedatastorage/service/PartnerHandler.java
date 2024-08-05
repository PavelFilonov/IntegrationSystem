package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Partner.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Partners;
import com.ru.corporatedatastorage.entity.Partner;
import com.ru.corporatedatastorage.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PartnerHandler implements RestHandler<Partners> {

	private final PartnerRepository partnerRepository;

	@Override
	@Transactional
	public void migrate(Partners dtoList) {
		val partnersDto = dtoList.getPartners();
		if (partnersDto == null || partnersDto.isEmpty()) {
			return;
		}
		val partners = partnersDto.stream()
				.map(dto -> mapFromDto(partnerRepository.findByExternalId(dto.getId()).orElse(new Partner()), dto))
				.toList();
		partnerRepository.saveAllAndFlush(partners);
	}

}
