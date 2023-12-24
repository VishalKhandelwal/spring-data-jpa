package com.vk.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.dto.EmployeeDTO;
import com.vk.entities.Employee;
import com.vk.exceptions.ResourceNotFoundException;
import com.vk.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub		
		return employeeRepository.save(employee);
	}
	
	@Override
	@Transactional
	public List<Employee> saveAllEmployee(List<Employee> employees) {
		// TODO Auto-generated method stub
		return employeeRepository.saveAll(employees);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesNameInAscOreder1() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<Employee> getEmployeesNameInAscOreder2() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Direction.ASC, "name"));
	}
	
	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with give id is not found on server !! : "+id));
		return employee;
	}
	
	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User with give email is not found on server !! : "+email));
		return employee;
	}
	
	@Override
	@Transactional
	public Employee updateEmployee(Employee updateEmployee,Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with give id is not found on server !! : "+id));

		return employeeRepository.save(updateEmployee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}	

	@Override
	public List<Employee> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDateOfBirthBetween(startDate, endDate);
	}

	@Override
	public Employee findByQueryEmail1(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByQueryEmail1(email).orElseThrow(()-> new ResourceNotFoundException("User with give email is not found on server !! : "+email));
	}

	@Override
	public String findByNativeQueryEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNativeQueryEmail(email).orElseThrow(()-> new ResourceNotFoundException("User with give email is not found on server !! : "+email));
	}

	@Override
	public EmployeeDTO findByNativeQueryEmailParam(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNativeQueryEmailParam(email).orElseThrow(()-> new ResourceNotFoundException("User with give email is not found on server !! : "+email));
	}

	

	

	
	

	

	

	

	
	
	
}