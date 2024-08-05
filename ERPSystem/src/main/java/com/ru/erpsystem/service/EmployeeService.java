package com.ru.erpsystem.service;

import static java.util.stream.Collectors.toList;

import com.ru.erpsystem.dto.edit.EmployeeEditDto;
import com.ru.erpsystem.dto.read.EmployeeReadDto;
import com.ru.erpsystem.entity.Employee;
import com.ru.erpsystem.exception.EntityNotFoundException;
import com.ru.erpsystem.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeService implements AbstractService<EmployeeReadDto, EmployeeEditDto, Employee, Long> {

	private final EmployeeRepository userRepository;

	@Override
	public EmployeeReadDto create(EmployeeEditDto dto) {
		val user = new Employee();
		return entityToDto(updateEntity(user, dto));
	}

	@Override
	public EmployeeReadDto update(Long id, EmployeeEditDto dto) {
		val user = one(id);
		return entityToDto(updateEntity(user, dto));
	}

	@Override
	public void delete(Long id) {
		val user = one(id);
		userRepository.delete(user);
	}

	@Override
	public EmployeeReadDto findById(Long id) {
		return entityToDto(one(id));
	}

	@Override
	public List<EmployeeReadDto> findAll() {
		return userRepository.findAll().stream().map(this::entityToDto).collect(toList());
	}

	@Override
	public EmployeeReadDto entityToDto(Employee entity) {
		return new EmployeeReadDto(entity);
	}

	@Override
	public Employee updateEntity(Employee entity, EmployeeEditDto editDto) {
		entity.setFirstName(editDto.getFirstName());
		entity.setLastName(editDto.getLastName());
		entity.setEmail(editDto.getEmail());
		entity.setPhone(editDto.getPhone());
		return userRepository.save(entity);
	}

	@Override
	public Employee one(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Employee.class, id));
	}

}
