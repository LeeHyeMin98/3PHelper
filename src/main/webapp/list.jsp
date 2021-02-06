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
<title>글 목록</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
<script>
	$(document).ready(function(){
		$("#btnInsert").click(function(){

			//페이지 주소 이동
			location.href="${path}/insertBoard.jsp";

		});
	});
	//원하는 페이지로 이동시 검색 조건, 키워드 값을 유지하기 위해
	function list(page){
		location.href="${path}/list.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keyword=${map.keyword}";
		
	}
</script>
<!-- 최상단 헤더 -->	
<div id="header"> 
  <nav>
      <ul id="hd"> 
      <li>
        <a href="">Home</a>
      </li>
      <li>
        <a href="">제도 확인</a>     
      </li>
      <li>
        <a href="">마감 예정 제도</a>       
      </li>
      <li>
        <a href="list.jsp">게시판</a>
      </li>
      <li>
        <a href="">문의</a>
      </li>
      <li>
        <a href="">내정보</a>
      </li> 
    </ul>
  </nav>
</div>
<!-- 홈페이지 들어가는 네비게이션 부분 -->
<div class="boardnav">
  <p class="title"><a href="#" class="page">홈페이지</a></p>
	<!-- 검색창 -->	
	<div class= "boardsearch" style="float:center">
		<form action="list.do" method="post">
			<table cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right" class="searchline"> 
					<select name="searchOption">
							<option value="TITLE" <c:out value="${map.searchOption=='title'?'selected' :'' }"/>>제목</option>
							<option value="CONTENT" <c:out value="${map.searchOption=='content'?'selected' :'' }"/>>내용</option>
					</select> 
					<input name="keyword" type="search" size=60 class="searchbar" value="${map.keyword}"/> 
					<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 검색창 종료 -->
</div>

<!-- 홈페이지 아래 회색 네비게이션바 -->
<div class="bar">
  <div class="barcontent">
  <a href="getBoardList.jsp" class="home">home</a> > 게시판
  </div>
</div>
 <br>
<!-- 해당 페이지 타이틀 -->
<div class="blist">
 게시판 목록
  <a href="insertBoard.jsp" class="write">글쓰기</a>
  <hr class="listhr"></hr>
  <div class="information">
    ※ 제도 관련 질문, 문의 등 정보 공유를 할 수 있는 게시판입니다.
  <!-- 게시글 목록 보여주는 테이블 -->
  <div>
	<table cellpadding="0" cellspacing="0" width="700" class="boardtable">
			<tr>
				<th width="100">번호</th>
				<th width="200">제목</th>
				<th width="150">작성자</th>
				<th width="170">등록일</th>
				<th width="100" class="thlast">조회수</th>
			</tr>
				<tr>
				<c:forEach var="board" items="${map.list}">
					<tr>
					<td>${board.seq}</td>
					<td><a href="view.do?seq=${board.seq}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}" class="boardtitle">${board.title}
					<!-- 댓글 있으면 게시물 이름 옆에 출력 -->
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
					<!-- 처음 페이지로 이동: 현재 페이지가 1보다 크면 [처음]하이퍼 링크를 화면에 출력 -->
					<c:if test="${map.boardPager.curBlock >1 }">
						<a href="javascript:list('1')">[처음]</a>
					</c:if>
					
					<!-- 이전페이지 블록으로 이동 -->
					<c:if test="${map.boardPager.curBlock >1}">
						<a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
					</c:if>
					
					<!-- 하나의 블럭에서 반복문 수행 시작 페이지 부터 끝 페이지까지 -->
					<c:forEach var="ROWNUMBER" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
						<!-- 현재 페이지이면 하이퍼링크 제거 -->
						<c:choose>
							<c:when test="${ROWNUMBER ==map.boardPager.curPage}">
								<span style="color: red">${ROWNUMBER}</span>&nbsp;
							</c:when>
							<c:otherwise>
								<a href="javascript:list('${ROWNUMBER}')">${ROWNUMBER}</a>&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<!-- 다음 페이지 블록으로 이동 -->
					<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
						<a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
					</c:if>
					
					<!-- 끝페이지로 이동 -->
					<c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
						<a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
					</c:if>
					</td> 
					</tr>
		</table>  
<br>
<br>
</body>
</html>