package com.ru.corporatedatastorage.dto.read;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

	private List<EmployeeReadDto> employees;

}
