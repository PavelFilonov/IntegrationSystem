package com.ru.webapp.service;

import static java.util.stream.Collectors.toList;

import com.ru.webapp.dto.edit.UserEditDto;
import com.ru.webapp.dto.read.UserReadDto;
import com.ru.webapp.entity.User;
import com.ru.webapp.exception.EntityNotFoundException;
import com.ru.webapp.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService implements AbstractService<UserReadDto, UserEditDto, User, Long> {

	private final UserRepository userRepository;

	@Override
	public UserReadDto create(UserEditDto dto) {
		val user = new User();
		return entityToDto(updateEntity(user, dto));
	}

	@Override
	public UserReadDto update(Long id, UserEditDto dto) {
		val user = one(id);
		return entityToDto(updateEntity(user, dto));
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
	public List<UserReadDto> findAll() {
		return userRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public UserReadDto entityToDto(User entity) {
		return new UserReadDto(entity);
	}

	@Override
	public User updateEntity(User entity, UserEditDto editDto) {
		entity.setUsername(editDto.getUsername());
		entity.setPassword(editDto.getPassword());
		return userRepository.save(entity);
	}

	@Override
	public User one(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
	}

}
