package com.ru.erpsystem.repository;

import com.ru.erpsystem.entity.BaseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.val;

public abstract class BaseRepository<E extends BaseEntity> {

	private final Map<Long, E> ENTITIES = new HashMap<>();

	private static Long ID_SEQUENCE;

	public BaseRepository() {
		ID_SEQUENCE = 1L;
	}

	public void delete(E entity) {
		ENTITIES.remove(entity.getId());
	}

	public E save(E entity) {
		Long id = entity.getId();
		if (id != null && ENTITIES.containsKey(id)) {
			ENTITIES.replace(id, entity);
		} else {
			entity.setId(ID_SEQUENCE);
			ENTITIES.put(ID_SEQUENCE, entity);
			ID_SEQUENCE++;
		}
		return entity;
	}

	public Optional<E> findById(Long id) {
		val entity = ENTITIES.getOrDefault(id, null);
		return entity != null ? Optional.of(entity) : Optional.empty();
	}

	public List<E> findAll() {
		return ENTITIES.values().stream().toList();
	}

}
