package com.ru.corporatedatastorage.service;

import com.ru.corporatedatastorage.dto.edit.UserEditDto;
import com.ru.corporatedatastorage.dto.read.UserReadDto;
import com.ru.corporatedatastorage.entity.User;
import com.ru.corporatedatastorage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements AbstractService<UserReadDto, UserEditDto, User, Long> {

	private final UserRepository userRepository;

	@Override
	public UserReadDto create(UserEditDto dto) {
		return null;
	}

	@Override
	public UserReadDto update(Long id, UserEditDto dto) {
		return null;
	}

	@Override
	public void delete(Long id) {
		val user = one(id);
		userRepository.delete(user);
	}

	@Override
	public UserReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public Page<UserReadDto> findAll(Pageable pageable) {
		return userRepository.findAll(pageable).map(this::entityToDto);
	}

	@Override
	public UserReadDto entityToDto(User entity) {
		return new UserReadDto(entity);
	}

	@Override
	public User updateEntity(User entity, UserEditDto editDto) {
		return null;
	}

	@Override
	public User one(Long id) {
		return null;
	}

}
