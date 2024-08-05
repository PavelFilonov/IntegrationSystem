package com.ru.erpsystem.dto.read;

import com.ru.erpsystem.entity.Employee;
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

	public EmployeeReadDto(Employee entity) {
		super(entity);
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
	}

}
