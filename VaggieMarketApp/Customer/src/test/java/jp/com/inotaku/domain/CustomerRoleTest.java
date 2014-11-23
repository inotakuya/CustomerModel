package jp.com.inotaku.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerRoleTest {

	@Test
	public void test() {
		CustomerRole customerRole1 = new CustomerRole();
		customerRole1.setCustomerRoleId(2L);
		System.out.println(customerRole1);
		CustomerRole customerRole2 = new CustomerRole(1L, new Role(1L, "ROLE_USER"));
		System.out.println(customerRole2);
	}

}
