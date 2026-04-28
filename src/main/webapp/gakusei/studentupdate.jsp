<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="../header.jsp" %>

<div class="inner-header">
	<div class="inner">
		<div class="header-title">学生情報変更</div>
		<div class="inner-nav"></div>
	</div>
</div>

<form action="UpdateExecute.action" method="post">
	<label class="lab">入学年度<br>
		<input name="ent_year" value="${entYear}" readonly />
	</label>
	<br>
	
	<label class="lab">学生番号<br>
		<input type="text" value="${no}" name="no" readonly />
	</label>
	<br>
	
<div class="form-group">
	<label class="lab">氏名<br>
		<input type="text" name="name" value="${name}"required maxlength="30" />
		<div class="error">${errors.get("name")}</div>
	</label>
</div>

<div class="form-group">
	<label class="lab">クラス<br>
		<select name="class_num">
			<c:forEach var="num" items="${classNumList}">
				<option value="${num.classNum}" ${num.classNum == classNum ? 'selected' : ''}>${num.classNum}</option>
			</c:forEach>
		</select>
	</label>
</div>

    <div class="form-group">
        <label style="display: inline-block;">在学中
        	<input type="checkbox" name="is_attend" value="true" ${isAttend ? 'checked' : ''} /> 
    	</label> 
    </div><br>
    
    <input type="submit" value="変更">
    
</form>
<a href="StudentList.action">戻る</a>

<%@include file = "../footer.jsp" %>
