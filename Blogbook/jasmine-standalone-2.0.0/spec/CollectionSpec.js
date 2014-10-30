describe("コレクションテスト", function() {
	it("spec1", function() {
		var blogList = new BlogList();
		expect(blogList.length).toBe(0);
		blogList.add(new Blog);
		expect(blogList.length).toBe(1);
	});
});