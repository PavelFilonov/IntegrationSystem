package com.ru.corporatedatastorage.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.ru.corporatedatastorage.dto.read.RequestReadDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "request")
public class Request extends BaseEntity {

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private String link;

	private Long externalId;

	public static Request mapFromDto(Request entity, RequestReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setLink(dto.getLink());
		return entity;
	}

}
