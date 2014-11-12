var application_root = __dirname;
var express = require('express');
var path = require('path');
var mongoose = require('mongoose');

var app = express();

var amqp = require('amqplib');
var when = require('when');



var allowCrossDomain = function(req, res, next) {
	res.header('Access-Control-Allow-Origin', '*');
	res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
	res.header('Access-Control-Allow-Headers', 'Content-Type, Authorization');
	
	if ('OPTIONS' == req.method) {
		res.send(200);
	}
	else {
		next();
	}
};
app.use(allowCrossDomain);

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
	amqp.connect('amqp://localhost').then(function(conn) {
		return when(conn.createChannel().then(function(ch) {
			var q = 'blog';
			var msg = JSON.stringify(blog);

			var ok = ch.assertQueue(q, {durable: false});

			return ok.then(function(_qok) {
				ch.sendToQueue(q, new Buffer(msg));
				console.log(" [x] Sent '%s'", msg);
				return ch.close();
			});
		})).ensure(function() { conn.close(); });
	}).then(null, console.warn);

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
		amqp.connect('amqp://localhost').then(function(conn) {
			return when(conn.createChannel().then(function(ch) {
				var q = 'blog';
				var msg = JSON.stringify(blog);

				var ok = ch.assertQueue(q, {durable: false});

				return ok.then(function(_qok) {
					ch.sendToQueue(q, new Buffer(msg));
					console.log(" [x] Sent '%s'", msg);
					return ch.close();
				});
			})).ensure(function() { conn.close(); });
		}).then(null, console.warn);

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


