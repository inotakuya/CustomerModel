var application_root = __dirname;
var express = require('express');
var path = require('path');
var mongoose = require('mongoose');

var app = express();

app.configure(function(){
	app.use(express.bodyParser());

	app.use(express.methodOverride());

	app.use(app.router);

	app.use(express.static(path.join(application_root,'site')));

	app.use(express.errorHandler({dumpException: true,showStack: true}));
});

app.get('/api',function(request,response){
	response.send('ライブラリのAPIを利用可能です。');
});

mongoose.connect('mongodb://localhost/blog_database');

var Blog = new mongoose.Schema({
	title: String,
	message: String
});

var BlogModel = mongoose.model('Blog',Blog);

app.get('/api/blogs',function(request,response){
	return BlogModel.find(function(err,blogs){
		if(!err){
			return response.send(blogs);
		}else{
			return console.log(err);
		}
	});
});

app.get('/api/blogs/:id',function(request,response){
	return BlogModel.findById(request.params.id,function(err,blog){
		if(!err){
			return response.send(blog);
		}else{
			return console.log(err);
		}
	});
	});

app.post('/api/blogs',function(request,response){
	var blog = new BlogModel({
		title:request.body.title,
		message:request.body.message
	});
	blog.save(function(err){
		if(!err){
			return console.log('追加されました。');
		}else{
			return console.log(err);
		}
	});
	return response.send(blog);
});



app.put('/api/blogs/:id',function(request,response){
	console.log('更新します: ' + request.body.title);
	return BlogModel.findById(request.params.id,function(err,blog){
		blog.title = request.body.title;
		blog.message = request.body.message;
		return blog.save(function(err){
			if(!err){
				console.log('更新されました。');
			}else{
				console.log(err);
			}
			return response.send(blog);
		});
	});
});

app.delete('/api/blogs/:id',function(request,response){
	console.log('削除するブログのID: ' + request.params.id);
	return BlogModel.findById(request.params.id,function(err,blog){
		return blog.remove(function(err){
			if(!err){
				console.log('ブログが削除されました。');
				return response.send('');
			}else{
				console.log(err);
			}
		});
	});
});

var port = 8070;
app.listen(port,function(){
	console.log('Expressサーバーがポート %d で起動しました。モード: %s',port,app.settings.env);
});



