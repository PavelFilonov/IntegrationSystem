package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Account.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Accounts;
import com.ru.corporatedatastorage.entity.Account;
import com.ru.corporatedatastorage.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountHandler implements RestHandler<Accounts> {

	private final AccountRepository accountRepository;

	@Override
	@Transactional
	public void migrate(Accounts dtoList) {
		val accountsDto = dtoList.getAccounts();
		if (accountsDto == null || accountsDto.isEmpty()) {
			return;
		}
		val accounts = accountsDto.stream()
				.map(dto -> mapFromDto(accountRepository.findByExternalId(dto.getId()).orElse(new Account()), dto))
				.toList();
		accountRepository.saveAllAndFlush(accounts);
	}

}
