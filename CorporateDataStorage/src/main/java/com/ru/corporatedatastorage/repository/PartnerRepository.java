package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Partner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

	Optional<Partner> findByExternalId(Long externalId);

}
