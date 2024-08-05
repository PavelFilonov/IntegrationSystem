package com.ru.corporatedatastorage.entity;

import com.ru.corporatedatastorage.dto.read.UserReadDto;
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
@Table(name = "users")
public class User extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	private Long externalId;

	public static User mapFromDto(User entity, UserReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setUsername(entity.getUsername());
		entity.setPassword(entity.getPassword());
		return entity;
	}

}
