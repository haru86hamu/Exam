<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>


<div class="inner-header">
	<div class="inner">
		<div class="header-title">学生管理</div>
		<div class="inner-nav"></div>
	</div>
</div>

<div class="touroku"><a href="StudentCreate.action">新規登録</a></div>

<form class="search" method="get" action="StudentList.action">
	<label for="year" class="lab">入学年度
		<select name="year" id="year" class="label">
			<option value="">--------</option>
			<option value="2017" ${year == '2017' ? 'selected' : ''}>2017</option>
			<option value="2018" ${year == '2018' ? 'selected' : ''}>2018</option>
			<option value="2019" ${year == '2019' ? 'selected' : ''}>2019</option>
			<option value="2020" ${year == '2020' ? 'selected' : ''}>2020</option>
			<option value="2021" ${year == '2021' ? 'selected' : ''}>2021</option>
			<option value="2022" ${year == '2022' ? 'selected' : ''}>2022</option>
			<option value="2023" ${year == '2023' ? 'selected' : ''}>2023</option>
			<option value="2024" ${year == '2024' ? 'selected' : ''}>2024</option>
			<option value="2025" ${year == '2025' ? 'selected' : ''}>2025</option>
			<option value="2026" ${year == '2026' ? 'selected' : ''}>2026</option>
		</select>
	</label>

	<label for="classnum" class="lab">クラス
		<select name="classnum" id="classnum" class="label">
			<option value="">-------</option>
			<c:forEach var="c" items="${classlist}">
				<option value="${c.classNum}" ${classnum == c.classNum ? 'selected' : ''}>${c.classNum}</option>
			</c:forEach>
		</select>
	</label>

	<label class="check">
		<input type="checkbox" name="attend" ${attend != null ? 'checked' : ''}>在学中
	</label>

	<button type="submit">絞り込み</button>
</form>

<c:choose>
	<c:when test="${list != null && list.size() > 0}">
		<div>検索結果: ${list.size()}件</div>
		<table class="table" border="1">
			<thead>
				<tr>
					<th>入学年度</th>
					<th>学生番号</th>
					<th>氏名</th>
					<th>クラス</th>
					<th>在学中</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${list}">
					<tr>
						<td>${student.entYear}</td>
						<td>${student.no}</td>
						<td>${student.name}</td>
						<td>${student.classNum}</td>
						<td>
							<c:choose>
								<c:when test="${student.isAttend}">○</c:when>
								<c:otherwise>×</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="StudentUpdate.action?no=${student.no}">変更</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>学生情報が取得できませんでした。</c:otherwise>
</c:choose>

<%@include file="../footer.jsp" %>
