package com.ru.corporatedatastorage.repository;

import com.ru.corporatedatastorage.entity.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByExternalId(Long externalId);

}
