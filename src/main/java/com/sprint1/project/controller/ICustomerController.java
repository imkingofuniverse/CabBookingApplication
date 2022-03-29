package com.sprint1.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.project.entity.Customer;

import com.sprint1.project.service.ICustomerService;

@RestController
@RequestMapping(value = "/customer")
public class ICustomerController {

	@Autowired
	ICustomerService customerService;

	@PostMapping("/login/{username}/{password}")
	public String validateCustomer(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		String response = "";

		try {
			Customer c = customerService.validateCustomer(username, password);
			if (c.getUsername().equals(null)) {
				response = "Invalid Customer-----Login Failed !!";

			} else {
				response = "Valid Customer-----Login Success !! \n" + c.toString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response = "Invalid Customer-----Login Failed !!";
		}
		return response;
	}

	@PostMapping("/insertCustomer")
	public Customer insertCustomer(@RequestBody Customer customer) {
		Customer cust = new Customer();
		try {
			cust = customerService.insertCustomer(customer);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return cust;
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {

		Customer cust = new Customer();
		try {
			cust = customerService.updateCustomer(customer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cust;
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int customerId) {
		Customer customer = new Customer();
		try {
			customer = customerService.deleteCustomer(customerId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@GetMapping(value = "/getAllCustomer")
	public List<Customer> viewCustomers() {
		List<Customer> cList = new ArrayList<Customer>();
		try {
			cList = customerService.viewCustomers();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cList;
	}

	@GetMapping(value = "/getCustomer/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) {
		Customer cust = null;
		try {
			cust = customerService.viewCustomer(customerId);
		} catch (Exception e) {
			// throw new CustomerNotFoundException("Customer with Id: " + customerId + " Not
			// Found!");
			System.out.println(e.getMessage());
		}
		return cust;
	}
}