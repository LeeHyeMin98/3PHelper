<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<c:if test="${session.uname==null }">
	<script>
		alert("�α��� �Ͻ� �Ŀ� ������ּ���");
		location.href="${path}/login.do";
	</script>
</c:if>
</head>
<body>

</body>
</html>