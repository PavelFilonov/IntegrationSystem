package com.ru.corporatedatastorage.entity;

import com.ru.corporatedatastorage.dto.read.ProductReadDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;

	@Column(length = -1)
	private String description;

	@Column(nullable = false)
	private Double price;

	private Long externalId;

	public static Product mapFromDto(Product entity, ProductReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		return entity;
	}

}
