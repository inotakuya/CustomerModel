var app = app || {};

app.BlogView = Backbone.View.extend({
    tagName: "div",
    className: "blogContainer",
 
    
    events:{
        "click .delete": "deleteBlog"
    },


    initialize:function(){
        _.templateSettings = {
            interpolate : /\{\{(.+?)\}\}/g
        };
         
    },

    render: function(){
   
       var template = _.template($("#blogTemplate").html());
        this.$el.html(template(this.model.toJSON()));
        return this;
    },
    
    deleteBlog: function(){
        this.model.destroy();
        this.remove();
    }
});