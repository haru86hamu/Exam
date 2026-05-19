<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">成績参照</div>
		<div class="inner-nav"></div>
	</div>
</div>

<form class="search" method="get" action="TestListSubject.action">
	<p style="margin-right: auto;">科目情報</p>
	<label for="year" class="lab">入学年度
		<select name="year" id="year" class="label" required>
			<option value="" ${year == '' ? 'selected' : ''}>--------</option>
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
		<select name="classnum" id="classnum" class="label" required>
			<option value=""${classnum == '' ? 'selected' : ''}>-------</option>
			<c:forEach var="c" items="${classlist}">
				<option value="${c.classNum}" ${classnum == c.classNum ? 'selected' : ''}>${c.classNum}</option>
			</c:forEach>
		</select>
	</label>

	<label class="lab">科目
		<select name="subject" id="subject" class="label" required>
			<option value=""${subject == '' ? 'selected' : ''}>------</option>
			<c:forEach var="subjectItem" items="${subjects}">
				<option value="${subjectItem.cd}" ${subject == subjectItem.cd ? 'selected' : ''}>${subjectItem.name}</option>
			</c:forEach>
		</select>
	</label>

	<button type="submit">検索</button>
</form>
<form class="search" method="get" action="TestListStudent.action">
	<p style="margin-right: auto;">学生情報</p>
	<label class="lab" style="margin-right: auto;">学生番号
		<input type="text" class="label" name="no" value="${no}" required maxlength="7">
	</label>

	<button type="submit">検索</button>
</form>


		
<c:choose>
	<c:when test="${empty testlist && empty stlist}">
		<label class="lab"><p>科目情報を選択または学生情報を入力して検索ボタンをクリックして下さい</p></label>
		
		<c:if test="${not empty message}">
			<div class="error">${message}</div>
		</c:if>
		
	</c:when>
	<c:when test="${not empty testlist}">
		<div>科目:${subname }</div>
		<table class="table" border="1">
			<thead>
				<tr>
					<th>入学年度</th>
					<th>クラス</th>
					<th>学生番号</th>
					<th>氏名</th>
					<th>1回目</th>
					<th>2回目</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="test" items="${testlist}">
					<tr>
						<td>${test.entYear}</td>
						<td>${test.classNum.classNum}</td>
						<td>${test.studentNo}</td>
						<td>${test.studentName}</td>
						<td>
							<c:choose>
								<c:when test="${test.getPoint(1) != null}">${test.getPoint(1)}</c:when>
								<c:when test="${test.getPoint(1) == null}">-</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${test.getPoint(2) != null}">${test.getPoint(2)}</c:when>
								<c:when test="${test.getPoint(2) == null}">-</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:when test="${not empty stlist}">
		<div>氏名:${name }(${no })</div>
		<table class="table" border="1">
			<thead>
				<tr>
					<th>科目名</th>
					<th>科目コード</th>
					<th>回数</th>
					<th>点数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="st" items="${stlist}">
					<tr>
						<td>${st.subjectName }</td>
						<td>${st.subjectCd }</td>
						<td>${st.num }</td>
						<td>${st.point }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
</c:choose>

<%@include file="../footer.jsp" %>
