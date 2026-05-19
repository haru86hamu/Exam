<%@page contentType="text/html; charset=UTF-8" %>
<%@include file = "../header.jsp" %>

<c:choose>
	<c:when test="${id != null }">
		<form action="LoginExecute.action" method="post">
		<p>ログイン名<input type="text" name="id" value="${id }"  ${id != null ? 'checked' : ''} required></p>
		<p>パスワード<input type="text" name="password"></p>
		<p><input type="submit" value="ログイン"></p>
		</form>
	</c:when>
	
	<c:when test="${id == null }">
		<form action="LoginExecute.action" method="post">
		<p>ログイン名<input type="text" name="id" required></p>
		<p>パスワード<input type="text" name="password"></p>
		<p><input type="submit" value="ログイン"></p>
		</form>
	</c:when>
</c:choose>
	
<c:if test="${not empty message}">
	<div class="error">${message}</div>
</c:if>
	
<%@include file = "../footer.jsp" %>