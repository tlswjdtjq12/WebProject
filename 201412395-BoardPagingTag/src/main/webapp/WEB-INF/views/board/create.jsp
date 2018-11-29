<!DOCTYPE=HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
    <!-- Bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../../resources/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class="container">
		<form class="form-horizantal" role="form" method="post" action="/board/createPost" enctype="multipart/form-data">
			 
			<div class="form-group">
			<label for="writer" class="col-xs-2 col-lg-2 control-label">작성자</label>
			<div class="col-xs-10 col-lg-10">
				<input type="text" class="form-control" name="writer" size="20" value='${login.id}'>
			</div>
			</div>
			<div class="form-group">
			<label for="title" class="col-xs-2 col-lg-2 control-label">제목</label>
			<div class="col-xs-10 col-lg-10">
				<input type="text" class="form-control" name="title" size="20">
			</div>
			</div>
			<div class="form-group">
			<label for="content" class="col-xs-2 col-lg-2 control-label">내용</label>
			<div class="col-xs-10 col-lg-10">
				<input type="text" class="form-control" name="content" size="20">
			</div>
			</div>
			<div class="form-group">
    		<label for="uploadFile" class="col-xs-2 col-lg-2 control-label">첨부파일</label>
   			 <div class="col-xs-10 col-lg-10">
     		<input type="file" class="form-control" name="uploadFile" multiple>
    		</div>
    		</div>
			<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 ">
				<input type="submit"class="btn btn-default" value="확인">
			</div>
			</div>
		</form>
		</div>
    <!-- Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../../../resources/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
	</body>
</html>