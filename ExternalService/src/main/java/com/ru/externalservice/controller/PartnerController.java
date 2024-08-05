package com.ru.externalservice.controller;

import com.ru.externalservice.dto.edit.PartnerEditDto;
import com.ru.externalservice.dto.read.PartnerReadDto;
import com.ru.externalservice.service.PartnerService;
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
@RequestMapping("/api/partners")
@RequiredArgsConstructor
public class PartnerController {

	private final PartnerService partnerService;

	@GetMapping
	public List<PartnerReadDto> findAll() {
		return partnerService.findAll();
	}

	@GetMapping("{id}")
	public PartnerReadDto findOne(@PathVariable Long id) {
		return partnerService.findById(id);
	}

	@PostMapping
	public PartnerReadDto create(@Validated @RequestBody PartnerEditDto dto) {
		return partnerService.create(dto);
	}

	@PutMapping("/{id}")
	public PartnerReadDto edit(@PathVariable Long id, @Validated @RequestBody PartnerEditDto dto) {
		return partnerService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		partnerService.delete(id);
	}

}
