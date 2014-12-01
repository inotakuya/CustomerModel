package jp.com.inotaku.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/application-config.xml",
		"file:src/main/webapp/WEB-INF/mvc-config.xml" })
@WebAppConfiguration
public class IndexControllerTest {

	@InjectMocks
	private IndexController indexController;

	private MockMvc mockMvc;

	@Mock
	private ItemService itemService;

	@Before
	public void setUp() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(indexController).setViewResolvers(
				viewResolver).build();
	}

	@Test
	public void testIndex() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/"))
				.andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().hasNoErrors()).andReturn();

		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) modelMap.get("itemList");
		assertThat(itemList, notNullValue());
		verify(itemService).findAllItems();
	}

	@Test
	public void testIndexPost() throws Exception {
		mockMvc.perform(post("/")).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void testCreateGet() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/create"))
				.andExpect(status().isOk()).andExpect(view().name("create"))
				.andReturn();

		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Item item = (Item) modelMap.get("item");
		assertThat(item, notNullValue(Item.class));
	}

	@Test
	public void testCreatePost() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/create"))
				.andExpect(status().isFound()).andExpect(redirectedUrl("/"))
				.andExpect(model().attributeExists("item")).andReturn();

		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Item item = (Item) modelMap.get("item");
		assertThat(item, notNullValue(Item.class));
		verify(itemService).saveItem((Item) anyObject());
	}

	@Test
	public void editTest() throws Exception {
		doReturn(new Item()).when(itemService).getItemById(anyLong());
		MvcResult mvcResult = mockMvc
				.perform(get("/update").param("itemId", "1"))
				.andExpect(status().isOk()).andExpect(view().name("update"))
				.andReturn();

		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Item item = (Item) modelMap.get("item");
		assertThat(item, notNullValue(Item.class));
		verify(itemService).getItemById(anyLong());
	}

	@Test
	public void edit2Test() throws Exception {
		mockMvc.perform(get("/update")).andExpect(status().isFound())
				.andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void updateTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/update")).andExpect(status().isFound())
				.andExpect(redirectedUrl("/")).andReturn();
		
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Item item = (Item)modelMap.get("item");
		assertThat(item, notNullValue(Item.class));
		verify(itemService).saveItem((Item)anyObject());
	}
	
}