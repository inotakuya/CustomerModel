package jp.com.inotaku.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.repository.CustomerRepository;
import jp.com.inotaku.repository.RoleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring/application-config.xml")
@Transactional
public class CustomerTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Before
	public void setUp(){
		Role userRole = new Role();
		Role adminRole = new Role();
		userRole.setRoleName("ROLE_USER");
		adminRole.setRoleName("ROLE_ADMIN");
		roleRepository.save(userRole);
		roleRepository.save(adminRole);
		Customer customer = new Customer(1, "user", "pass", roleRepository.findAll());
		customerRepository.save(customer);
	}
	
	@Test
	public void test() {
		assertThat(customerRepository.findAll().get(0).getRoleList().get(0).getRoleName(), is("ROLE_USER"));
	}

}
