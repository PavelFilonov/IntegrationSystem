package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByExternalId(Long externalId);

}
