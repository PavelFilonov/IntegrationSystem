package com.ru.erpsystem.service;

import com.ru.erpsystem.dto.read.ResponseDto;
import java.util.List;

public interface AbstractService<RD extends ResponseDto, ED, E, I> {

	RD create(ED dto);

	RD update(I id, ED dto);

	void delete(I id);

	RD findById(I id);

	List<RD> findAll();

	RD entityToDto(E entity);

	E updateEntity(E entity, ED editDto);

	E one(I id);

}
