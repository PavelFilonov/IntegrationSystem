package com.ru.corporatedatastorage.entity;

import com.ru.corporatedatastorage.dto.read.PartnerReadDto;
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
@Table(name = "partner")
public class Partner extends BaseEntity {

	@Column(nullable = false)
	private String address;

	private Long externalId;

	public static Partner mapFromDto(Partner entity, PartnerReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setAddress(dto.getAddress());
		return entity;
	}

}
