package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;

@RestController
public class EmployeeClientController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/saveEmployeeClient1", method = RequestMethod.POST)
	public ResponseEntity<String> saveEmployee1(@RequestBody Employee employee) {
		System.out.println("####### client1: " + employee.toString());
		restTemplate.postForEntity("http://localhost:8080/saveEmployee", employee,Employee.class);
		return new ResponseEntity<String>("{}", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/saveEmployeeClient2", method = RequestMethod.POST)
	public Employee saveEmployee2(@RequestBody Employee employee) {
		System.out.println("####### client2: " + employee.toString());
		restTemplate.postForLocation("http://localhost:8080/saveEmployee", employee);
		return employee;
	}
}
