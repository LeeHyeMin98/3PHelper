<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- <script type="text/javascript" src="./js/login_form.js?ver=1"></script>
-->
<!--  <script type="text/javascript">
	$('login_m').click(function(){
		$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
	$('create_m').click(function(){
		$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
</script>  -->

<script>
	$(document).ready(function(){
		$("#btnlogin").click(function(){
			document.form1.action="${path}/list.do"
		})
	})
</script>

<link rel="stylesheet" href="./login_form.css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="username" />
      <input type="password" placeholder="password" />
      <input type="email" placeholder="email"/>
      <input type="number" placeholder="age"/>
    <p>��������
       <input type="checkbox" id="checkb_btn1" name="job">
      <label for="checkb_btn1"></label> </p>
 
 <br>
      <button>create</button>
      <p class="login_m">�̹� �����ϼ̳���? <a href="login_form.jsp">�α���</a></p>
    </form>

    <form class="login-form" method="post">
      <input type="text" name="uname" placeholder="�̸�" value="${user.uname }"/>
      <input type="password" name="upw" placeholder="��й�ȣ" value="${user.upw }"/>
      <button type="submit" id="btnlogin">login</button>
      <p class="create_m">ȸ������ �ϱ� <a href="register.jsp">Create an account</a></p>
      <p class="find_m">������ �����̳���? <a href="find_form.jsp">Find an account</a></p>
    </form> 
  </div>
 </div>
</body>
</html>