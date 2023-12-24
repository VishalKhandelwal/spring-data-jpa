package com.vk.service;

import java.time.LocalDate;
import java.util.List;

import com.vk.dto.EmployeeDTO;
import com.vk.entities.Employee;

public interface EmployeeService {
 
	public Employee saveEmployee(Employee employee);
	public List<Employee> saveAllEmployee(List<Employee> employees);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesNameInAscOreder1();
	public List<Employee> getEmployeesNameInAscOreder2();
	public Employee getEmployee(Long id);
	public Employee getEmployeeByEmail(String email);
	public Employee updateEmployee(Employee employee,Long id);
	public void deleteEmployee(Long id);
	public List<Employee> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
	public Employee findByQueryEmail1(String email);
	public String findByNativeQueryEmail(String email);
	public EmployeeDTO findByNativeQueryEmailParam(String email);

	
}