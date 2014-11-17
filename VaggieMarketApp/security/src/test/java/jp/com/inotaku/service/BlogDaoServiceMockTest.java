package jp.com.inotaku.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.Blog;
import jp.com.inotaku.service.BlogService;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class BlogDaoServiceMockTest {

    //private EasyMock easyMock;    //private MockControl mockControl;
    private BlogService blogService;
    private BlogDao blogDao;
	private List<Blog> blogList = new ArrayList<Blog>();

    @Before
    public void init() {
    	blogDao = EasyMock.createMock(BlogDao.class);
        blogService = new BlogServiceImpl(blogDao);
    }	
	
	@Test
	public void GetAllBlogTest() throws Exception {
    	Blog b = new Blog();
    	b.setBlogId(100L);
    	b.setTitle("My Blog");
    	b.setMessage("My Blog's description");
    	blogList.add(b);
    	EasyMock.expect(blogDao.findAll()).andReturn(blogList);
    	EasyMock.expectLastCall().atLeastOnce();
    	EasyMock.replay(blogDao);
    	blogService.getAllBlog();
    	EasyMock.verify(blogDao);	
	}

	@Test(expected = Exception.class)
	public void GetAllBlogExceptionTest() throws Exception {
    	Blog b = new Blog();
    	b.setBlogId(100L);
    	b.setTitle("My Blog");
    	b.setMessage("My Blog's description");
    	blogList.add(b);
    	EasyMock.expect(blogDao.findAll()).andReturn(null);
    	EasyMock.expectLastCall().atLeastOnce();
    	EasyMock.replay(blogDao);
    	blogService.getAllBlog();
    	EasyMock.verify(blogDao);	
	}
	
}
