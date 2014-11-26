package jp.com.inotaku.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.repository.CustomerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerService CustomerService = new CustomerServiceImpl();
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Test
	public void test() {
		List<Customer> customers = new ArrayList<Customer>();
		doReturn(customers).when(customerRepository).findAll();
		List<Customer> actual = CustomerService.findAllCustomers();
		assertThat(actual, is(customers));
		verify(customerRepository).findAll();
	}

}
