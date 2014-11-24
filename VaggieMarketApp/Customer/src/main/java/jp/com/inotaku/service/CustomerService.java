package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	
	public List<Customer> findAllCustomer();
}
