package com.ru.accountingsystem.dto.read;

import com.ru.accountingsystem.entity.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductReadDto extends ResponseDto {

	private String name;

	private String description;

	private Double price;

	public ProductReadDto(Product entity) {
		super(entity);
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
	}

}
