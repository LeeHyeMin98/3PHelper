<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<c:if test="${session.uname==null }">
	<script>
		alert("로그인 하신 후에 사용해주세요");
		location.href="${path}/login.do";
	</script>
</c:if>
</head>
<body>

</body>
</html>