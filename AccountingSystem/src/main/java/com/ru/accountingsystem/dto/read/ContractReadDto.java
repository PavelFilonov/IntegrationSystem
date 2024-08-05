package com.ru.accountingsystem.dto.read;

import com.ru.accountingsystem.entity.Contract;
import java.time.LocalDateTime;
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
public class ContractReadDto extends ResponseDto {

	private String text;

	private LocalDateTime effectiveFrom;

	private LocalDateTime effectiveTo;

	private PartnerReadDto partner;

	public ContractReadDto(Contract entity) {
		super(entity);
		this.text = entity.getText();
		this.effectiveFrom = entity.getEffectiveFrom();
		this.effectiveTo = entity.getEffectiveTo();
	}

}
