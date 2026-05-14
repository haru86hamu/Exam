<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">科目変更</div>
		<div class="inner-nav"></div>
	</div>
</div>

<form class="seach" action="DeleteExecute.action" method="post">
	<label class="lab">
		<input type="hidden" id ="cd" name="cd" value="${cd }" readonly="readonly">
	</label>
	<label class="lab">
		<input type="hidden" id ="name" name="name" value="${name }" required>
	</label>
	<label>
	<p>「${name }(${cd })」を削除してもよろしいですか？</p>
	</label>
	
	<button type="submit">削除</button>
</form>
<a href="SubjectList.action">戻る</a>

<%@include file="../footer.jsp" %>
