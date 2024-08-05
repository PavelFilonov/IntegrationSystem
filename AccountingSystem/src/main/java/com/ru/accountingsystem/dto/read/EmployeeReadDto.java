package com.ru.accountingsystem.dto.read;

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
public class EmployeeReadDto extends ResponseDto {

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

}
