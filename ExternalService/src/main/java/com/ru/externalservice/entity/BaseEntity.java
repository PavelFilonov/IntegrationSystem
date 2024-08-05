package com.ru.externalservice.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
public class BaseEntity {

	private Long id;

}
