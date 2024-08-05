package com.ru.erpsystem.dto.edit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEditDto {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

}
