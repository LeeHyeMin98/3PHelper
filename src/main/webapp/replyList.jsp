<%@page contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!--  안될 때-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">

</head>
<body>
	<table style="width:700px">
		<c:forEach var="reply" items="${mav.list}">
			<tr>
				<td>
					${reply.uname}(<fmt:formatDate value="${reply.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/>)
					<br>
					${reply.replytext}
				</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>