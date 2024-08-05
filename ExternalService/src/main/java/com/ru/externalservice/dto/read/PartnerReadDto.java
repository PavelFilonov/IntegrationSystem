package com.ru.externalservice.dto.read;

import com.ru.externalservice.entity.Partner;
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
public class PartnerReadDto extends ResponseDto {

	private String address;

	public PartnerReadDto(Partner entity) {
		super(entity);
		this.address = entity.getAddress();
	}

}
