<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(document).ready(function(){
		$("#btnlogin").click(function(){
			var uname =$("#uname").val();
			var upw =$("#upw").val();
			if(uname==""){
				alert("아이디를 입력하세요.");
				$("#uname").focus();//입력 포커스 이동
				return;
			}
			if(upw==""){
				alert("비밀번호를 입력하세요");
				$("#upw").focus();
				return;
			}
			//내부 데이터 전송 주소
			document.form1.action="${path}/loginCheck.do";
			//제출
			document.form1.submit();
			//document.form1.action="${path}/list.do";
		})
	})
</script>

<link rel="stylesheet" href="/login_form.css?ver=0.2"/>

</head>
<body>

   <form  name = form2 class="register-form">
      <input type="text" placeholder="username" />
      <input type="password" placeholder="password" />
      <input type="email" placeholder="email"/>
      <input type="number" placeholder="age"/>
    <p>재직여부
       <input type="checkbox" id="checkb_btn1" name="job">
      <label for="checkb_btn1"></label> </p>
 
 <br>
      <button>create</button>
      <p class="login_m">이미 가입하셨나요? <a href="login.jsp">로그인</a></p>
    </form> 

    <form name = form1 action="login.do" method="post">
      <input type="text" name="uname"  id="uname" placeholder="이름" value="${member.uname }"/>
      <input type="password" name="upw" id="upw" placeholder="비밀번호" value="${member.upw }"/>

      <button type="submit" id="btnlogin" onClick="btnlogin()" >login</button>

      
      <p class="create_m">회원가입 하기 <a href="register.jsp">Create an account</a></p>
      <p class="find_m">계정을 잊으셨나요? <a href="find_form.jsp">Find an account</a></p>
    </form> 

</body>
</html>