package jp.com.inotaku.domain;

import static org.junit.Assert.*;
import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.User;
import jp.com.inotaku.repository.UserRipository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application*.xml")
public class UserTest {

	@Autowired
	private UserRipository userRipository;
	
	private User user1;
	
	@Before
	public void init(){
		user1 = new User("user", "user", true);
		userRipository.save(user1);
	}
	
	@Test
	public void test() {
		System.out.println(userRipository.findAll());
		
	}

}
