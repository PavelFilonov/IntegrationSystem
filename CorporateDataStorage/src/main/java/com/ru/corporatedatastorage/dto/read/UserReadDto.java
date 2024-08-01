package com.ru.corporatedatastorage.dto.read;

import com.ru.corporatedatastorage.entity.User;
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
public class UserReadDto extends ResponseDto {

	private String username;

	private String password;

	public UserReadDto(User entity) {
		super(entity);
		this.username = entity.getUsername();
		this.password = entity.getPassword();
	}

}
