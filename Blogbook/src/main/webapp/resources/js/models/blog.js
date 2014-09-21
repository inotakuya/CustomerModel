var app = app || {};

app.Blog = Backbone.Model.extend({

    idAttribute: "blogId",
    
    defaults:{
        title: "無題",
        message: "なし"
    }
});