package jp.com.inotaku.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.domain.Role;
import jp.com.inotaku.repository.CustomerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Test
	public void findAllCustomerstest() {
		List<Customer> customers = new ArrayList<Customer>();
		doReturn(customers).when(customerRepository).findAll();
		List<Customer> actual = customerService.findAllCustomers();
		assertThat(actual, is(customers));
		verify(customerRepository).findAll();
	}

	@Test
	public void saveCustomertest() throws Exception {
		customerService.saveCustomer(new Customer());
		verify(customerRepository).save((Customer)anyObject());
	}
	
	@Test
	public void deleteCustomertest() throws Exception {
		customerService.deleteCustomer(1L);
		verify(customerRepository).delete(anyLong());
		verify(customerRepository,never()).delete((Customer)anyObject());
	}
}
