package com.ru.externalservice.exception;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class EntityNotFoundException extends RuntimeException {

  private static final String ENTITY_NOT_FOUND = "Entity not found";

  public EntityNotFoundException(Class<?> clazz, Long id) {
    super(format(ENTITY_NOT_FOUND + " '%s' '%s'", clazz.getName(), id.toString()));
  }

}
