package jp.com.inotaku.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.repository.CustomerRepository;
import jp.com.inotaku.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.kubek2k.springockito.annotations.WrapWithSpy;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
@Transactional
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	
	
	private Customer customer1;
	private Customer customer2;
	
	@Before
	public void init(){
		customer1 = new Customer(1, "user", "0001",null);
		customerService.saveCustomer(customer1);
		CustomerRoleService customerRoleService = Mockito.mock(CustomerRoleService.class);
		
	}
	
	@Test
	public void test() {
		List<Customer> customers = customerService.findAllCustomer();
		System.out.println(customers.get(0));
		assertThat(customers.get(0).getCustomerRoleList().get(0).getCustomerRoleId(), is(1L));
	}

}
