package com.ru.webapp.dto.read;

import com.ru.webapp.entity.Request;
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
public class RequestReadDto extends ResponseDto {

	private Long userId;

	private String link;

	public RequestReadDto(Request entity) {
		super(entity);
		this.userId = getOptionalId(entity.getUser());
		this.link = entity.getLink();
	}

}
