<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" href="./find_form.css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="find-page">
  <div class="form">
      <form class="find-form" action="${pageContext.request.contextPath}"/>
      <input type="text" placeholder="이름"/>
      <input type="email" placeholder="email"/>
      <button type="submit">비밀번호 변경 이메일 발송</button>
      <p class="login_m">로그인하기 <a href="login_form.do">Sign In</a></p>
    </form>
  </div> 
</div>
</body>
</html>