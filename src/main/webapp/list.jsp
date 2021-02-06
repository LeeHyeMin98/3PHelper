<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./getBoardList.css?ver=133"/>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
<script>
	$(document).ready(function(){
		$("#btnInsert").click(function(){

			//������ �ּ� �̵�
			location.href="${path}/insertBoard.jsp";

		});
	});
	//���ϴ� �������� �̵��� �˻� ����, Ű���� ���� �����ϱ� ����
	function list(page){
		location.href="${path}/list.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keyword=${map.keyword}";
		
	}
</script>
<!-- �ֻ�� ��� -->	
<div id="header"> 
  <nav>
      <ul id="hd"> 
      <li>
        <a href="">Home</a>
      </li>
      <li>
        <a href="">���� Ȯ��</a>     
      </li>
      <li>
        <a href="">���� ���� ����</a>       
      </li>
      <li>
        <a href="list.jsp">�Խ���</a>
      </li>
      <li>
        <a href="">����</a>
      </li>
      <li>
        <a href="">������</a>
      </li> 
    </ul>
  </nav>
</div>
<!-- Ȩ������ ���� �׺���̼� �κ� -->
<div class="boardnav">
  <p class="title"><a href="#" class="page">Ȩ������</a></p>
	<!-- �˻�â -->	
	<div class= "boardsearch" style="float:center">
		<form action="list.do" method="post">
			<table cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right" class="searchline"> 
					<select name="searchOption">
							<option value="TITLE" <c:out value="${map.searchOption=='title'?'selected' :'' }"/>>����</option>
							<option value="CONTENT" <c:out value="${map.searchOption=='content'?'selected' :'' }"/>>����</option>
					</select> 
					<input name="keyword" type="search" size=60 class="searchbar" value="${map.keyword}"/> 
					<input type="submit" value="�˻�" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- �˻�â ���� -->
</div>

<!-- Ȩ������ �Ʒ� ȸ�� �׺���̼ǹ� -->
<div class="bar">
  <div class="barcontent">
  <a href="getBoardList.jsp" class="home">home</a> > �Խ���
  </div>
</div>
 <br>
<!-- �ش� ������ Ÿ��Ʋ -->
<div class="blist">
 �Խ��� ���
  <a href="insertBoard.jsp" class="write">�۾���</a>
  <hr class="listhr"></hr>
  <div class="information">
    �� ���� ���� ����, ���� �� ���� ������ �� �� �ִ� �Խ����Դϴ�.
  <!-- �Խñ� ��� �����ִ� ���̺� -->
  <div>
	<table cellpadding="0" cellspacing="0" width="700" class="boardtable">
			<tr>
				<th width="100">��ȣ</th>
				<th width="200">����</th>
				<th width="150">�ۼ���</th>
				<th width="170">�����</th>
				<th width="100" class="thlast">��ȸ��</th>
			</tr>
				<tr>
				<c:forEach var="board" items="${map.list}">
					<tr>
					<td>${board.seq}</td>
					<td><a href="view.do?seq=${board.seq}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}" class="boardtitle">${board.title}
					<!-- ��� ������ �Խù� �̸� ���� ��� -->
					<c:if test="${board.recnt >0 }">
					<span style="color:blue;">(${board.recnt})
					</span>
					</c:if>
					</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
					<td class="lasttd">${board.cnt}</td>
					</tr>
				</c:forEach>	
				</tr>
				</table>
		<br>
		</div>
  </div>
</div>
		<table>
			<tr>
				<td colspan="5">
					<!-- ó�� �������� �̵�: ���� �������� 1���� ũ�� [ó��]������ ��ũ�� ȭ�鿡 ��� -->
					<c:if test="${map.boardPager.curBlock >1 }">
						<a href="javascript:list('1')">[ó��]</a>
					</c:if>
					
					<!-- ���������� ������� �̵� -->
					<c:if test="${map.boardPager.curBlock >1}">
						<a href="javascript:list('${map.boardPager.prevPage}')">[����]</a>
					</c:if>
					
					<!-- �ϳ��� ������ �ݺ��� ���� ���� ������ ���� �� ���������� -->
					<c:forEach var="ROWNUMBER" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
						<!-- ���� �������̸� �����۸�ũ ���� -->
						<c:choose>
							<c:when test="${ROWNUMBER ==map.boardPager.curPage}">
								<span style="color: red">${ROWNUMBER}</span>&nbsp;
							</c:when>
							<c:otherwise>
								<a href="javascript:list('${ROWNUMBER}')">${ROWNUMBER}</a>&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<!-- ���� ������ ������� �̵� -->
					<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
						<a href="javascript:list('${map.boardPager.nextPage}')">[����]</a>
					</c:if>
					
					<!-- ���������� �̵� -->
					<c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
						<a href="javascript:list('${map.boardPager.totPage}')">[��]</a>
					</c:if>
					</td> 
					</tr>
		</table>  
<br>
<br>
</body>
</html>