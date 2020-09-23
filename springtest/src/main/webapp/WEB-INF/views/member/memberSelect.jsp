<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 class="page_title">내정보조회</h3>
	<div><span class="label">아이디: </span><span> ${member.id} </span></div>
	<div><span class="label">비번: </span><span> ${member.pw} </span></div>
	<div><span class="label">직업: </span><span> ${member.job} </span></div>
	<div><span class="label">성별: </span><span> ${member.gender} </span></div>
	<div><span class="label">메일수신여부: </span><span> ${member.mailyn} </span></div>
	<div><span class="label">가입동기: </span><span> ${member.reason} </span></div>
	<div><span class="label">취미: </span><span> ${member.hobby} </span></div>
	<div><span class="label">가입날짜: </span><span> ${member.regdate} </span></div>
	<div>
		<button type="button" id="btnBack">목록</button>
	</div>
	
	<script>
		btnBack.addEventListener("click",function(){
			//history.back();
			//history.go(-1); //이전페이지로 이동
			//location.href="memberAll.jsp"
			location.assign("memberAll.jsp");
		});
		
	</script>
</body>
</html>