package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByExternalId(Long externalId);

}
