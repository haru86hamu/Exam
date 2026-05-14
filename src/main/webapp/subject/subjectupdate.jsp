<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">科目変更</div>
		<div class="inner-nav"></div>
	</div>
</div>

<c:if test="${not empty message}">
	<div class="error">${message}</div>
</c:if>

<form class="seach" action="UpdateExecute.action" method="post">
	<label class="lab">科目コード<br>
		${cd }
		<input type="hidden" id ="cd" name="cd" value="${cd }" readonly="readonly">
	</label><br>
	<label class="lab">科目名<br>
		<input type="text" id ="name" name="name" value="${name }" required>
	</label><br>
	
	<br><button type="submit">変更</button>
</form>
<a href="SubjectList.action">戻る</a>

<%@include file="../footer.jsp" %>
