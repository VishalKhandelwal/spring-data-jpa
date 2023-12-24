package com.vk.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vk.dto.EmployeeDTO;
import com.vk.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	List<Employee> findAllByOrderByNameAsc();
	Optional<Employee> findByEmail(String email);
	List<Employee> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
	//-------native query example----------------------
	@Query("From Employee where email = ?1")
	Optional<Employee> findByQueryEmail1(String email);
	@Query(value="Select name from employee where email = ?1",nativeQuery = true)
	Optional<String> findByNativeQueryEmail(String email);
	//--------------Data transaction mapping example------------
	@Query(value="Select name,email from employee where email = :email",nativeQuery = true)
	Optional<EmployeeDTO> findByNativeQueryEmailParam(@Param("email") String email);

	
}
