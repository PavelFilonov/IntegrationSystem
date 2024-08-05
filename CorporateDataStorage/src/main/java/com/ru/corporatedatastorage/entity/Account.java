package com.ru.corporatedatastorage.entity;

import com.ru.corporatedatastorage.dto.read.AccountReadDto;
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
@Table(name = "account")
public class Account extends BaseEntity {

	@Column(nullable = false)
	private Double cost;

	@Column(nullable = false, length = -1)
	private String description;

	private Long externalId;

	public static Account mapFromDto(Account entity, AccountReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setCost(dto.getCost());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}
