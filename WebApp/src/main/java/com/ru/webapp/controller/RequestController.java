package com.ru.webapp.controller;

import com.ru.webapp.dto.edit.RequestEditDto;
import com.ru.webapp.dto.read.RequestReadDto;
import com.ru.webapp.service.RequestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class RequestController {

	private final RequestService requestService;

	@GetMapping
	public List<RequestReadDto> findAll() {
		return requestService.findAll();
	}

	@GetMapping("{id}")
	public RequestReadDto findOne(@PathVariable Long id) {
		return requestService.findById(id);
	}

	@PostMapping
	public RequestReadDto create(@Validated @RequestBody RequestEditDto dto) {
		return requestService.create(dto);
	}

	@PutMapping("/{id}")
	public RequestReadDto edit(@PathVariable Long id, @Validated @RequestBody RequestEditDto dto) {
		return requestService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		requestService.delete(id);
	}

}
