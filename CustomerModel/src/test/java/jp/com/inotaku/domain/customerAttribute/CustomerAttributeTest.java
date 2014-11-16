package jp.com.inotaku.domain.customerAttribute;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.domain.CustomerAttribute;
import jp.com.inotaku.domain.Dao.CustomerAttributeDao;
import jp.com.inotaku.repository.CustomerAttributeRepository;
import jp.com.inotaku.service.CustomerAttributeService;
import jp.com.inotaku.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/application*.xml")
@Transactional
public class CustomerAttributeTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerAttributeService customerAttributeService;
	
	@Autowired
	private CustomerAttributeRepository customerAttributeRepository;
	
	@Autowired
	private CustomerAttributeDao customerDao;
	
	private Customer customer1;
	private Customer customer2;
	private CustomerAttribute customerAttribute1;
	private CustomerAttribute customerAttribute2;
	private CustomerAttribute customerAttribute3;
	private CustomerAttribute customerAttribute4;
	
	@Before
	public void init(){
		customer1 = new Customer(1, 1, "0001");
		customer2 = new Customer(2, 2, "0002");
		customerService.saveCustomer(customer1);
		customerService.saveCustomer(customer2);
		customerAttribute1 = new CustomerAttribute(100, "abc", "def", customer1);
		customerAttribute2 = new CustomerAttribute(200, "ghi", "jkl", customer1);
		customerAttribute3 = new CustomerAttribute(300, "ace", "gil", customer2);
		customerAttribute4 = new CustomerAttribute(400, "xxx", "zzz", customer2);
		customerAttributeService.saveCustomerAttribute(customerAttribute1);
		customerAttributeService.saveCustomerAttribute(customerAttribute2);
		customerAttributeService.saveCustomerAttribute(customerAttribute3);
		customerAttributeService.saveCustomerAttribute(customerAttribute4);
	}
	@Test
	public void test() {
	List<CustomerAttribute> customerAttributes = customerAttributeRepository.findByNameLikeAndLocaleCode("a","01");
	assertThat(customerAttributes.size(),is(1));
	}

}
