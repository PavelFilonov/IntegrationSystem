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
public class Contract extends BaseEntity {

	private String text;

	private LocalDateTime effectiveFrom;

	private LocalDateTime effectiveTo;

	private Long partnerId;

}
