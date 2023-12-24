package com.vk.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.dto.EmployeeDTO;
import com.vk.entities.Employee;
import com.vk.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private Logger Logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee saveEmployee = employeeService.saveEmployee(employee);
		Logger.info("createEmployee method called................");
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
	}
	
	@PostMapping("/all")
	public ResponseEntity<List<Employee>> saveAllEmployee(@RequestBody List<Employee> employee){
		List<Employee> saveAllEmployee = employeeService.saveAllEmployee(employee);
		return new ResponseEntity<List<Employee>>(saveAllEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployee = employeeService.getEmployees();
		return ResponseEntity.ok(allEmployee);
	}
	
	@GetMapping("/name-asc")
	public ResponseEntity<List<Employee>> getAllEmployeeName(){
		List<Employee> allEmployee = employeeService.getEmployeesNameInAscOreder1();
		return ResponseEntity.ok(allEmployee);
	}
	
	@GetMapping("/name-ascc")
	public ResponseEntity<List<Employee>> getAllEmployeeNameAsc(){
		List<Employee> allEmployee = employeeService.getEmployeesNameInAscOreder2();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
		 Employee employee = employeeService.getEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email){
		 Employee employee = employeeService.getEmployeeByEmail(email);
		return ResponseEntity.ok(employee);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
		Employee updateEmployee = employeeService.updateEmployee(employee, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateEmployee);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deleteEmployee(@RequestParam(value = "id",required = true) Long id){
		 employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/dob/{startDate}/{endDate}")
	public ResponseEntity<List<Employee>> getEmployeeBetween(@PathVariable("startDate") LocalDate startDate, @PathVariable LocalDate endDate){
		 List<Employee> employees = employeeService.findByDateOfBirthBetween(startDate, endDate);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/email1/{email}")
	public ResponseEntity<Employee> findByQueryEmail1(@PathVariable("email") String email){
		 Employee employee = employeeService.findByQueryEmail1(email);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/email2/{email}")
	public ResponseEntity<String> findByNativeQueryEmail(@PathVariable("email") String email){
		 String employee = employeeService.findByNativeQueryEmail(email);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/email3/{email}")
	public ResponseEntity<EmployeeDTO> findByNativeQueryEmailParam(@PathVariable("email") String email){
		EmployeeDTO employee = employeeService.findByNativeQueryEmailParam(email);
		return ResponseEntity.ok(employee);
	}
	
	

}
