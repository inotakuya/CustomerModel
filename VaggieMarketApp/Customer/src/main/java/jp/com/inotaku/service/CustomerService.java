package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();

}
