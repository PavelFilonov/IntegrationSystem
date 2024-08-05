package com.ru.corporatedatastorage.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.ru.corporatedatastorage.dto.read.PurchaseReadDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase extends BaseEntity {

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@Column(nullable = false)
	private LocalDateTime purchasedAt;

	private Long externalId;

	public static Purchase mapFromDto(Purchase entity, PurchaseReadDto dto) {
		entity.setExternalId(dto.getId());
		entity.setPurchasedAt(dto.getPurchasedAt());
		return entity;
	}

}
