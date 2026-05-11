<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">学生管理</div>
		<div class="inner-nav"></div>
	</div>
</div>

<div class="touroku"><a href="CreateExecute.action">新規登録</a></div>
<table class="table" border="1">
			<thead>
				<tr>
					<th>科目コード</th>
					<th>科目名</th>
					<th></th>
					<th></th>
					
				</tr>
			</thead>
<c:choose>
	<c:when test="${list != null && list.size() > 0}">
			<tbody>
				<c:forEach var="subject" items="${list}">
					<tr>
						<td>${subject.cd}</td>
						<td>${subject.name}</td>
						<td>
							<a href="SubjectUpdateExecute.Action">変更</a>
						</td>
						<td>
							<a href="">削除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</c:when>
</c:choose>
</table>

<%@include file="../footer.jsp" %>
