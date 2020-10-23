<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="   crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/11.1.1/classic/ckeditor.js"></script>
</head>
<body>
<img src="./images/Desert.jpg" style="width:300px">
<form action="./insertBoard.do" method="post" enctype="multipart/form-data">
	title <input type="text" name="title" value="${user.title}"><br>
	writer <input type="text" name="writer" value="${user.writer}"><br>
	content<textarea rows="5" cols="40" name="content" id="content"></textarea><br>
	<script>
    ClassicEditor
        .create( document.querySelector( '#content' ),{
        	ckfinder: {
                uploadUrl: './fileupload' // 내가 지정한 업로드 url (post로 요청감)
            }} )
        .catch( error => {
            console.error( error );
        } );
</script> 
	<input type="file" name="uploadFile"><br> 
	<input type="file" name="uploadFile"><br> 
	<input type="file" name="uploadFile"><br>
	<input type="submit" value="등록"/>
</form>
</body>
</html>