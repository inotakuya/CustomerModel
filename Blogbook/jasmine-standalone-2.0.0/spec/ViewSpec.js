describe("ビューテスト", function() {
	it("spec1", function() {
		spyOn(BlogListView.prototype,'render').and.callThrough();
		spyOn(BlogListView.prototype,'renderBlog').and.callThrough();
		var blog3 = new Blog();
		var blogListView = new BlogListView(blog3);
		expect(blogListView.render).toHaveBeenCalled();
		expect(blogListView.renderBlog).toHaveBeenCalledWith(blog3);
		
	});
});