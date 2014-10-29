describe("モデルテスト", function() {
	it("spec1", function() {
		var blog = new Blog();
		expect(blog.has("title")).toBeTruthy();
	});
});