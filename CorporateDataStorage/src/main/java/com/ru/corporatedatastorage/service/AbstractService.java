package com.ru.corporatedatastorage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractService<RD, ED, E, I> {

	RD create(ED dto);

	RD update(I id, ED dto);

	void delete(I id);

	RD findById(I id);

	Page<RD> findAll(Pageable pageable);

	RD entityToDto(E entity);

	E updateEntity(E entity, ED editDto);

	E one(I id);

}
