package com.ru.accountingsystem.dto.read;

import com.ru.accountingsystem.entity.Purchase;
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
public class PurchaseReadDto extends ResponseDto {

	private ProductReadDto product;

	private EmployeeReadDto employee;

	private LocalDateTime purchasedAt;

	public PurchaseReadDto(Purchase entity) {
		super(entity);
		this.purchasedAt = entity.getPurchasedAt();
	}

}
