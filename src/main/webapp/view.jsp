<%@page contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!--  안될 때-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="http://example.com/myicon.png"> 

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"> </script> -->
<script>
	$(document).ready(function(){
		//listReply();
		listReply2();//Json 리턴 방식
		//댓글 쓰기 버튼 클릭 이벤트 (ajax 처리)
		$("#btnReply").click(function(){ 
			var replytext=$("#replytext").val();
			var seq="${board.seq}"
			var param="replytext="+replytext+"&seq="+seq;
			$.ajax({
				type: "post",
				url:"${path}/reply/insert.do",
				data: param,
				success: function(){
					alert("댓글이 등록되었습니다");
					listReply2();
				} 
			});
			
		});
		
		//목록 버튼 클릭
		$("#btnList").click(function(){
			location.href="${path}/list.do?curPage=${curPage}&searchOption=${searchOption}&keyword=${keyword}";
		})
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="${path}/deleteBoard.do";
				document.form1.submit();
			}
		});
		$("#btnUpdate").click(function(){
			var title=$("#title").val();
			var content=$("#content").val();
			document.form1.action="${path}/updateBoard.do";
			document.form1.submit();
			});
	});
	
	//Controller방식 _listReply2();-->listReply(); 선언 필요
	function listReply(){
		$.ajax({ 
			type:"get",
			url:"${path}/reply/list.do?seq=${board.seq}",
			success:function(result){
				//responseText가 result에 저장
				$("#listReply").html(result);
			}
		});
	}  
	
/* 	//Json방식 now
	function listReply2(){
		$.ajax({
			type:"get",
			url:"${path}/reply/listJson.do?seq=${board.seq}",
			contentType: "application/json",
			success:function(result){
				console.log(result);
				var output="<table>";
				for(var i in result){
					output += "<tr>";
					output += "<td>"+result[i].uname;
					output += "(" + changeDate(result[i].regdate)+")<br>";
					output += result[i].replytext+"</td>";
					output += "<tr>";
				}
				output += "</table>";
				//responseText가 result에 저장
				$("#listReply").html(result);
			}
		});
	} */
	
	function listReply2(){
	    $.ajax({
	        type: "get",
	        contentType: "application/json",
	        url:"${path}/reply/listJson.do?seq=${board.seq}",
	        success: function(result){
	            console.log(result);
	            var output="<table>";
	            for(var i in result){
	                var repl=result[i].replytext;
	                repl = repl.replace(/  /gi,"&nbsp;&nbsp;");//공백처리
	                repl = repl.replace(/</gi,"&lt;"); //태그문자 처리
	                repl = repl.replace(/>/gi,"&gt;");
	                repl = repl.replace(/\n/gi,"<br>"); //줄바꿈 처리
	                
	                output += "<tr><td>"+result[i].uname;
	                date = changeDate(result[i].regdate);
	                output += "("+date+")";
	                output += "<br>"+repl+"</td></tr>";
	            }
	                output+="</table>";
	                $("#listReply").html(output);
	        }
	    });
	}
	//날짜 변환 함수
	function changeDate(date){
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month= date.getMonth();
		day=date.getDate();
		hour=date.getHours();
		minute=date.getMinutes();
		second=date.getSeconds();
		strDate =year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		return strDate;
	}
	
	
</script>
		

</head>
<body>
	<center>
		<h1>글 상세</h1>
		 <a href="logout.do">Log-out</a>
		<hr>
		 <form name=form1 action="view.do" method="post">
			<input name="seq" type="hidden" value="${board.seq}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="${board.title}" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
						${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<div style="width:650px; text-align: center;">
					<c:if test="${sessionScope.uname==board.writer}">
						<button type="button" id="btnUpdate" onClick="btnUpdate()">글 수정</button>
						<button type="button" id="btnDelete" onClick="btnDelete()" >글 삭제</button>
					</c:if>
					<!-- 상세 보기 화면에서 게시글 목록 화면으로 이동 -->
					<button type="button" id="btnList" onClick="btnList">목록</button>
				</div> 
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="list.do">글목록</a>
		<div style="width:650px; text-align: center;">
			<br>
				<!-- 로그인한 회원에게만 댓글 작성-->
				<c:if test="${sessionScope.uname != null}">
				<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해주세요"></textarea>
				<br>
				<button type="button" id="btnReply" onClick="btnReply">댓글 작성</button>
				</c:if>
			</div>
	</center>
	<!-- 댓글 출력 위치 -->
	<div id="listReply"></div>

</body>
</html>