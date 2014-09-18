package jp.com.inotaku.controller;

import java.util.List;

import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.Blog;
import jp.com.inotaku.servise.BlogService;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/message")
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String message(Model model){
		model.addAttribute("message","メッセージ");
		model.addAttribute("blog",new Blog());
		List<Blog> bloglist = blogService.getAllBlog();
		model.addAttribute("bloglist", bloglist);
		return "showMessage";
	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String addmessage(@ModelAttribute Blog blog,Model model){
		blogService.addBlog(blog);
		return "redirect:/message/";
		
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public String update( long blogId){
		Blog blog = new Blog();
		blog.setBlogId(blogId);
		blog.setMessage("アップデート");
		blog.setTitle("新");
		blogService.update(blog);
		return "redirect:/message/";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String delete(long blogId){
		blogService.deleteBlog(blogId);
		return "redirect:/message/";
	}
}
