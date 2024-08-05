package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByExternalId(Long externalId);

}
