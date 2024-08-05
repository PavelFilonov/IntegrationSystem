package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.User.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Users;
import com.ru.corporatedatastorage.entity.User;
import com.ru.corporatedatastorage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserHandler implements RestHandler<Users> {

	private final UserRepository userRepository;

	@Override
	@Transactional
	public void migrate(Users dtoList) {
		val usersDto = dtoList.getUsers();
		if (usersDto == null || usersDto.isEmpty()) {
			return;
		}
		val users = usersDto.stream()
				.map(dto -> mapFromDto(userRepository.findByExternalId(dto.getId()).orElse(new User()), dto))
				.toList();
		userRepository.saveAllAndFlush(users);
	}

}
