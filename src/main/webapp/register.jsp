<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./register_form.css" ></link>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div class="login-page">
  <div class="form">
    <form class="register-form" action="register.do" method="get" autocomplete="off">
      <input type="text" placeholder="name" name="uname"/>
      <input type="password" placeholder="pw" name="upw"/>
      <input type="email" placeholder="email" name="uemail"/>
      <input type="number" placeholder="age" name="uage"/>
    <p>재직여부
       <input type="checkbox" id="checkb_btn1" name="ujob">
      <label for="checkb_btn1"></label> </p>
 
<br>
      <button type="submit">가입완료</button>
      <p class="login_m">이미 가입하셨나요? <a href="login.do">로그인</a></p>
    </form>
  </div>
</div>
</body>
</html>