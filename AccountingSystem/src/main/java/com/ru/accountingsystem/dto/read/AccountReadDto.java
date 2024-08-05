package com.ru.accountingsystem.dto.read;

import com.ru.accountingsystem.entity.Account;
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
public class AccountReadDto extends ResponseDto {

	private Double cost;

	private String description;

	public AccountReadDto(Account entity) {
		super(entity);
		this.cost = entity.getCost();
		this.description = entity.getDescription();
	}

}
