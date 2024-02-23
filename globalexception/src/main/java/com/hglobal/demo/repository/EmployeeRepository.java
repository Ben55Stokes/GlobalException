package com.hglobal.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hglobal.demo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query(value = "select * from employee where employeename=:employeeName", nativeQuery = true)
	Optional<EmployeeEntity> findEmployeeByName(@Param("employeeName") String employeeName);

	@Query(value = "select * from employee where email_id=:emailID", nativeQuery = true)
	Optional<EmployeeEntity> findEmployeeByEmailID(@Param("emailID") String emailID);

}
