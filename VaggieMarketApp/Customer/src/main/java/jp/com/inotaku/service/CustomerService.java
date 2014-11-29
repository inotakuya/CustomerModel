package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public void saveCustomer(Customer customer);

	public void deleteCustomer(long customerId);

	public void saveUserCustomer(Customer customer);

}
