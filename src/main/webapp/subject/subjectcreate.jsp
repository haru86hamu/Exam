<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">科目登録</div>
		<div class="inner-nav"></div>
	</div>
</div>

<c:if test="${not empty message}">
	<div class="error">${message}</div>
</c:if>

<form class="seach" action="CreateExecute.action" method="post">
	<label class="lab">科目コード<br>
		<input type="text" id="cd" name="cd" value="${cd}" required placeholder="科目コードを入力してください">
	</label><br>
	<label class="lab">科目名<br>
		<input type="text" id="name" name="name" value="${name}" required placeholder="科目名を入力してください">
	</label><br>

	<button type="submit">登録</button>
</form>
<br>
<div>
	<a href="SubjectList.action">科目一覧に戻る</a>
</div>

<%@include file="../footer.jsp" %>
