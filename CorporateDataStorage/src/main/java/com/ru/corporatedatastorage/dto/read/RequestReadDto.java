package com.ru.corporatedatastorage.dto.read;

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

	private UserReadDto user;

	private String link;

}
