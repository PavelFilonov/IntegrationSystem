package com.ru.webapp.controller;

import com.ru.webapp.dto.edit.UserEditDto;
import com.ru.webapp.dto.read.UserReadDto;
import com.ru.webapp.service.UserService;
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
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserReadDto> findAll() {
		return userService.findAll();
	}

	@GetMapping("{id}")
	public UserReadDto findOne(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PostMapping
	public UserReadDto create(@Validated @RequestBody UserEditDto dto) {
		return userService.create(dto);
	}

	@PutMapping("/{id}")
	public UserReadDto edit(@PathVariable Long id, @Validated @RequestBody UserEditDto dto) {
		return userService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

}
