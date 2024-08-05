package com.ru.accountingsystem.dto.edit;

import java.time.LocalDateTime;
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
public class ContractEditDto {

	private Long id;

	private String text;

	private LocalDateTime effectiveFrom;

	private LocalDateTime effectiveTo;

	private Long partnerId;

}
