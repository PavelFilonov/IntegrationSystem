package com.ru.corporatedatastorage.service;

import static com.ru.corporatedatastorage.entity.Request.mapFromDto;

import com.ru.corporatedatastorage.dto.read.Requests;
import com.ru.corporatedatastorage.entity.Request;
import com.ru.corporatedatastorage.repository.RequestRepository;
import com.ru.corporatedatastorage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RequestHandler implements RestHandler<Requests> {

	private final RequestRepository requestRepository;

	private final UserRepository userRepository;

	@Override
	@Transactional
	public void migrate(Requests dtoList) {
		val requestsDto = dtoList.getRequests();
		if (requestsDto == null || requestsDto.isEmpty()) {
			return;
		}
		val requests = requestsDto.stream()
				.map(dto -> {
					val entity = mapFromDto(requestRepository.findByExternalId(dto.getId()).orElse(new Request()), dto);
					entity.setUser(userRepository.findById(dto.getUser().getId()).orElseThrow());
					return entity;
				})
				.toList();
		requestRepository.saveAllAndFlush(requests);
	}

}
