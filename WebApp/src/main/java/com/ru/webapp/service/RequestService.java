package com.ru.webapp.service;

import static java.util.stream.Collectors.toList;

import com.ru.webapp.dto.edit.RequestEditDto;
import com.ru.webapp.dto.read.RequestReadDto;
import com.ru.webapp.entity.Request;
import com.ru.webapp.exception.EntityNotFoundException;
import com.ru.webapp.repository.RequestRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestService implements AbstractService<RequestReadDto, RequestEditDto, Request, Long> {

	private final RequestRepository requestRepository;

	private final UserService userService;

	@Override
	public RequestReadDto create(RequestEditDto dto) {
		val entity = new Request();
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public RequestReadDto update(Long id, RequestEditDto dto) {
		val entity = one(id);
		return entityToDto(updateEntity(entity, dto));
	}

	@Override
	public void delete(Long id) {
		val entity = one(id);
		requestRepository.delete(entity);
	}

	@Override
	public RequestReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<RequestReadDto> findAll() {
		return requestRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public RequestReadDto entityToDto(Request entity) {
		return new RequestReadDto(entity);
	}

	@Override
	public Request updateEntity(Request entity, RequestEditDto editDto) {
		entity.setUser(userService.one(editDto.getUserId()));
		entity.setLink(editDto.getLink());
		return requestRepository.save(entity);
	}

	@Override
	public Request one(Long id) {
		return requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Request.class, id));
	}

}
