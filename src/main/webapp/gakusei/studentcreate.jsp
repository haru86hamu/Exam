<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>


<div class="inner-header">
	<div class="inner">
		<div class="header-title">学生管理</div>
		<div class="inner-nav"></div>
	</div>
</div>

<c:if test="${stmessage != null}">
	<div>${stmessage}</div>
</c:if>

<c:if test="${message != null}">
	<div>${message}</div>
</c:if>

<form action="CreateExecute.action" method="post">
	<label for="year" class="lab">入学年度
		<select name="year" id="year" required="required" class="">
			<option value="">--------</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option>
			<option value="2023">2023</option>
			<option value="2024">2024</option>
			<option value="2025">2025</option>
			<option value="2026">2026</option>
		</select>
	</label>
	
	<label class="lab">学生番号
		<input type="text" name="no" value="${no }" required maxlength="7" class="">
	</label>
	
	<label class="lab">氏名
		<input type="text" name="name" value="${name }" required class="">
	</label>
	
	<label for="classnum" class="lab">クラス
		<select name="classnum" id="classnum" class="">
			<c:forEach var="c" items="${classlist}">
				<option value="${c.classNum}" ${classnum == c.classNum ? 'selected' : ''}>${c.classNum}</option>
			</c:forEach>
		</select>
	</label>
	
	<button type="submit">登録して終了</button>
</form>

<a href="StudentList.action">戻る</a>
