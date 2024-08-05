package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Purchase;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	Optional<Purchase> findByExternalId(Long purchaseId);

}
