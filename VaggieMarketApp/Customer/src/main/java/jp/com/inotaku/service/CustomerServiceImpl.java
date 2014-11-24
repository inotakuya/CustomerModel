package jp.com.inotaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.repository.CustomerRepository;
import lombok.Setter;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	


	@Autowired
	private CustomerRepository CustomerRepository;
	
	@Autowired
	private CustomerRoleService customerRoleService;
	
	
	@Override
	public void saveCustomer(Customer customer) {
		CustomerRepository.save(customer);
	}
	
	public CustomerServiceImpl(){}
	public CustomerServiceImpl(CustomerRepository customerRepository){
		this.CustomerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAllCustomer() {
		return CustomerRepository.findAll();
	}



}
