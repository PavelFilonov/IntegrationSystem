package com.ru.accountingsystem.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase extends BaseEntity {

	private Product product;

	private Long employeeId;

	private LocalDateTime purchasedAt;

}
