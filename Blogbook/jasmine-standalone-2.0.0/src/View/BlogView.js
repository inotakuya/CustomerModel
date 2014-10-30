var BlogView = Backbone.View.extend({
	tagName:'div',
	className:'blogContainer',
	template: _.template($('#blogtemplate').html()),

	render: function(){
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});