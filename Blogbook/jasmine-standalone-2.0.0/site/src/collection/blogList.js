var BlogList = Backbone.Collection.extend({
	model:Blog,
	url:'/api/blogs'
});