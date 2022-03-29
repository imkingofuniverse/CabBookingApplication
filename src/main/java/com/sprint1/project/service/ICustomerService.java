package com.sprint1.project.service;
import java.util.List;

import com.sprint1.project.entity.Customer;
import com.sprint1.project.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException;

	public List<Customer> viewCustomers() throws CustomerNotFoundException;

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;

	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}