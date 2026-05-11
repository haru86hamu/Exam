<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="../header.jsp" %>



=======
<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">学生登録</div>
		<div class="inner-nav"></div>
	</div>
</div>

<form class="seach" action="CreateExecute.action" method="post">
	<label class="lab">科目コード<br>
		<input type="text" id ="cd" value="${cd }" placeholder="科目コードを入力してください">
	</label><br>
	<label class="lab">科目名<br>
		<input type="text" id ="name" value="${name }" placeholder="科目名を入力してください">
	</label><br>
	
	<button type="submit">登録</button>
</form>
>>>>>>> branch 'master' of https://github.com/haru86hamu/Exam.git

<%@include file="../footer.jsp" %>