package jp.com.inotaku.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application*.xml")
public class RoleServiceTest {
	
	@Autowired
	private RoleService roleService;

	@Test
	public void saveRoleTest() {
		Role role = new Role();
		roleService.saveRole(role);
		List<Role> roleList = roleService.findAllRole();
		assertThat(roleList.get(0).getRoleName(), is("ROLE_USER"));
		
	}

}
