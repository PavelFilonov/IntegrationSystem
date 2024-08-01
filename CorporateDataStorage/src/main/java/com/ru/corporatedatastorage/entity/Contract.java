package com.ru.corporatedatastorage.entity;

import static jakarta.persistence.FetchType.LAZY;

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
@Table(name = "contract")
public class Contract extends BaseEntity {

	@Column(nullable = false, length = -1)
	private String text;

	@Column(nullable = false)
	private LocalDateTime effectiveFrom;

	@Column(nullable = false)
	private LocalDateTime effectiveTo;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "partner_id", nullable = false)
	private Partner partner;

}
