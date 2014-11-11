package jp.com.inotaku.servise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.Blog;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public List<Blog> getAllBlog() {
		return blogDao.findAll();
	}

	public Blog findByIdgetBlog(long blogId) {
		return blogDao.findByBlogId(blogId);
	}

	public void update(Blog blog) {
		blogDao.update(blog);
	}

	public void addBlog(Blog blog) {
		blogDao.creat(blog);
	}

	public void deleteBlog(Long blogId) {
		blogDao.delete(blogId);
	}

}
