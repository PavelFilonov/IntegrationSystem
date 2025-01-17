package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Contract;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

	Optional<Contract> findByExternalId(Long externalId);

}
