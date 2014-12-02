package jp.com.inotaku.service;

import static org.junit.Assert.*;

import java.util.List;

import jp.com.inotaku.annotation.DataSets;
import jp.com.inotaku.domain.Item;
import jp.com.inotaku.listener.DatabaseTestExcutionListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/test/resources/spring/testConfig.xml",
		"file:src/main/resources/spring/application-config.xml" })
@TestExecutionListeners({ DatabaseTestExcutionListener.class })
@ActiveProfiles("test")
public class ItemServiceImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ItemService itemService;

	@DataSets(setUpDataSet = "src/test/resources/ItemServiceImplTest.xls")
	@Test
	public void testName() throws Exception {
		List<Item> result = itemService.findAllItems();
		System.out.println(result);
		/*deleteFromTables("ITEM");*/

	}
}
