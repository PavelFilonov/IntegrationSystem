package com.ru.corporatedatastorage.entity;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

@Audited
@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "app_generator")
	@SequenceGenerator(name = "app_generator", sequenceName = "app_seq", allocationSize = 10)
	private Long id;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date", nullable = false)
	private LocalDateTime updatedDate;

}
