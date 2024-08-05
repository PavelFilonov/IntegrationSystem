package com.ru.corporatedatastorage.service;

public interface RestHandler<T> {

	void migrate(T dtoList);

}
