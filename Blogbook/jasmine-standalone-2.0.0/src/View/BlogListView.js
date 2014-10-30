var BlogListView = Backbone.View.extend({
	initialize:function(item){
		this.collection = new BlogList(item);
		this.render();
	},
	render:function(){
		this.collection.each(function(item) {
			console.log(item);
			this.renderBlog(item);
		},this);
		
	},
	renderBlog: function(item){
		var blogView = new BlogView({
			model:item
		});
	
	}
});