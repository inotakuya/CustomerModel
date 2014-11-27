package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll(); 
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(long customerId) {
		customerRepository.delete(customerId);
	}

}
