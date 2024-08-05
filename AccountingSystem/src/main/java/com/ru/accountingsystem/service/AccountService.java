package com.ru.accountingsystem.service;

import static java.util.stream.Collectors.toList;

import com.ru.accountingsystem.dto.edit.AccountEditDto;
import com.ru.accountingsystem.dto.read.AccountReadDto;
import com.ru.accountingsystem.entity.Account;
import com.ru.accountingsystem.exception.EntityNotFoundException;
import com.ru.accountingsystem.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountService implements AbstractService<AccountReadDto, AccountEditDto, Account, Long> {

	private final AccountRepository accountRepository;

	@Override
	public AccountReadDto create(AccountEditDto dto) {
		val entity = new Account();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public AccountReadDto update(Long id, AccountEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		accountRepository.delete(entity);
	}

	@Override
	public AccountReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<AccountReadDto> findAll() {
		return accountRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public AccountReadDto entityToDto(Account entity) {
		return new AccountReadDto(entity);
	}

	@Override
	public Account updateEntity(Account entity, AccountEditDto editDto) {
		entity.setCost(editDto.getCost());
		entity.setDescription(editDto.getDescription());
		return accountRepository.save(entity);
	}

	@Override
	public Account one(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Account.class, id));
	}

}
