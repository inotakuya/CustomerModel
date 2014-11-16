package jp.com.inotaku.servise;

import java.util.List;

import jp.com.inotaku.domain.Blog;

public interface BlogService {

	List<Blog> getAllBlog();
	
	Blog findByIdgetBlog(long blogId);
	
	void update(Blog blog);
	
	void addBlog(Blog blog);
	
	void deleteBlog(Long blogId);
		
	
}
