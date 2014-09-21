var app = app || {};

app.LibraryView  = Backbone.View.extend({
    el: "#blogs",

    events:{
        "click #add": "addBlog"
    },

    initialize: function(){
        this.collection = new app.Library();
        this.collection.fetch({reset:true});
        this.render();
        this.listenTo(this.collection,"add",this.renderBlog);
        this.listenTo(this.collection,"reset",this.render);
    },

    render: function(){
        this.collection.each(function(item){
            this.renderBlog(item);
        },this);
    },

    renderBlog: function(item){
        var blogView = new app.BlogView({
            model: item
        });
        this.$el.append(blogView.render().el);
    },

    addBlog: function(e){
        e.preventDefault();
        var formData = {};
        $("#addBlog div").children("input").each(function(i,el){
            if($(el).val() != ""){
                formData[el.id] = $(el).val();
                $(el).val("");
                
            }
        });
        this.collection.create(formData);
    }
});