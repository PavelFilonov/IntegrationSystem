package com.ru.erpsystem.dto.read;

import static java.util.Optional.ofNullable;

import com.ru.erpsystem.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class ResponseDto {

  private Long id;

  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  protected ResponseDto(BaseEntity entity) {
    this.id = entity.getId();
  }

  protected Long getOptionalId(BaseEntity entity) {
    return ofNullable(entity).map(BaseEntity::getId).orElse(null);
  }

  protected <T, I> T getOptionalValue(Supplier<I> entitySupplier, Function<I, T> valueFunction) {
    return ofNullable(entitySupplier.get()).map(valueFunction).orElse(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseDto that = (ResponseDto) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
