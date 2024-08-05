package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Request;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	Optional<Request> findByExternalId(Long externalId);

}
