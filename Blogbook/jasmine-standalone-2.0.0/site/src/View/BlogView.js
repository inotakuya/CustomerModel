var BlogView = Backbone.View.extend({
	tagName:'div',
	className:'blogContainer',
	template: _.template($('#blogtemplate').html()),

	events:{
		'click .delete':'deleteBlog',
		'dblclick .view':'edit'
	},

	initialize:function(){

	},

	render: function(){
		this.$el.html(this.template(this.model.toJSON()));
		return this;
		this.$input = this.$('.edit');
	},

	deleteBlog:function(){
		this.model.destroy();
		this.remove();
	},

	edit: function(){
		this.$el.addClass('editing');
		this.$input.focus();
	}
});