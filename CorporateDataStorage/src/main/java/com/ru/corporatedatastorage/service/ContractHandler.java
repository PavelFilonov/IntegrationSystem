package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Contract.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Contracts;
import com.ru.corporatedatastorage.entity.Contract;
import com.ru.corporatedatastorage.repository.ContractRepository;
import com.ru.corporatedatastorage.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContractHandler implements RestHandler<Contracts> {

	private final ContractRepository contractRepository;

	private final PartnerRepository partnerRepository;

	@Override
	@Transactional
	public void migrate(Contracts dtoList) {
		val contractsDto = dtoList.getContracts();
		if (contractsDto == null || contractsDto.isEmpty()) {
			return;
		}
		val contracts = contractsDto.stream()
				.map(dto -> {
					val entity = mapFromDto(contractRepository.findByExternalId(dto.getId()).orElse(new Contract()), dto);
					entity.setPartner(partnerRepository.findById(dto.getPartner().getId()).orElseThrow());
					return entity;
				}).toList();
		contractRepository.saveAllAndFlush(contracts);
	}

}
