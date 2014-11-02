describe("ビューテスト", function() {
	afterEach(function(){
		$('.delete').trigger('click');
	});
	it("spec1", function() {
		spyOn(BlogListView.prototype,'render').and.callThrough();
		spyOn(BlogListView.prototype,'renderBlog');
		var blog3 = new Blog();
		var blogListView = new BlogListView(blog3);
		expect(blogListView.render).toHaveBeenCalled();

	});
	
	it("spec2", function(){
		spyOn(BlogListView.prototype,'addBlog').and.callThrough;
		var blogListView = new BlogListView({title:"aaa",message:"abc"});
		$('#add').trigger('click');
		expect(blogListView.addBlog).toHaveBeenCalled();
		var blogListView2 = new BlogListView(new Blog);
	});

	it("spec3", function() {
		$('#title').val('タイトル');
		$('#message').val('メッセージ');
		$('#add').trigger('click');
		console.log($('.blogContainer > ul:first').text());
	});
});
