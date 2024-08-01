package com.ru.corporatedatastorage.entity;

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

}
