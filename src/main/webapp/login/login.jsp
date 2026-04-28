<%@page contentType="text/html; charset=UTF-8" %>
<%@include file = "../header.jsp" %>


<form action="LoginExecute.action" method="post">
<p>ログイン名<input type="text" name="id" required></p>
<p>パスワード<input type="text" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>
	
	

<%@include file = "../footer.jsp" %>