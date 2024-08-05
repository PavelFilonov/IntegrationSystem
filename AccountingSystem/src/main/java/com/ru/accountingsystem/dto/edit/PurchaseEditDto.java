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
public class PurchaseEditDto {

	private Long id;

	private Long productId;

	private Long employeeId;

	private LocalDateTime purchasedAt;

}
