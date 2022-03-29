package com.sprint1.project.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.Customer;
import com.sprint1.project.exception.CustomerNotFoundException;
import com.sprint1.project.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> cust = customerRepository.findById(customer.getCustomerId());
		if (cust.isPresent()) {

			throw new CustomerNotFoundException("Customer Already exists !!");
		} else {
			customer = customerRepository.saveAndFlush(customer);
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> cust = customerRepository.findById(customer.getCustomerId());
		if (cust.isPresent()) {
			customer.setEmail(customer.getEmail());
			customer.setMobileNumber(customer.getMobileNumber());
			customer.setUsername(customer.getUsername());
			customer.setPassword(customer.getPassword());
			customerRepository.save(customer);

		} else {
			throw new CustomerNotFoundException("Customer does not exist !!");

		}
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> cust = customerRepository.findById(customerId);
		if (cust.isPresent()) {

			customerRepository.deleteById(customerId);
		} else {
			throw new CustomerNotFoundException("Customer Not Found !!");
		}
		return cust.get();

	}

	@Override
	public List<Customer> viewCustomers() throws CustomerNotFoundException {

		List<Customer> cList = customerRepository.findAll();
		if (cList.isEmpty()) {
			throw new CustomerNotFoundException("No Customer is Present");
		}
		return cList;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {

		Optional<Customer> cust = customerRepository.findById(customerId);
		if (!cust.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found !!");
		}

		return cust.get();
	}

	@Override
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException {

		TypedQuery<Customer> q = em.createQuery("select c from Customer c where username=:uname and password=:pass",
				Customer.class);
		q.setParameter("uname", username);
		q.setParameter("pass", password);
		List<Customer> custList = q.getResultList();
		Customer validCust = new Customer();
		if (custList.size() > 0)
			validCust = custList.get(0);
		else
			throw new CustomerNotFoundException("Invalid Customer !! ");
		return validCust;

	}

}