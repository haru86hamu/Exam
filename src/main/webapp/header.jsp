<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
	<div class="main-header">
	    <div class="header-inner">
	        <div class="header-title">得点管理システム</div>
	        <div class="header-nav">
	        <c:if test="${not empty sessionScope.teacher}">
	            <span class="user-info">${teacher.name} 様</span>
	
	            <form action="../logout/Logout.action" method="post" style="display: inline;">
	                <input type="submit" value="ログアウト" class="logout-btn">
	            </form>
	        </c:if>
	        </div>
	    </div>
	</div>
	<style>
	    .main-header {
	        background-color: #e9f1fb;
	        padding: 20px 40px;
	        border-bottom: 1px solid #ccc;
	        margin-left: 40px;
	        margin-right: 40px;
	    }
	
	    .header-inner {
	        display: flex;
	        justify-content: space-between;
	        align-items: center;
	    }
	
	    .header-title {
	        font-size: 24px;
	        font-weight: bold;
	    }
	    .logout-btn {
	        background: none;
	        border: none;
	        color: #007bff;
	        text-decoration: underline;
	        cursor: pointer;
	        padding: 0;
	    }
		.wrapper {
	    	display: flex;
	        margin-left: 40px;
	        margin-right: 40px;
		}
		.main-content {
	        margin-left: 10px;
	        padding: 0;
	        flex: 1;
	        margin-right: 50px;
	        margin-bottom: 40px;
	    }
		.sidebar{
			width: 180px;
	        padding-left: 0px;
	        top: 0;
	        right: 30px;
	        height: 500px;
	        
		}
		.sidebar--inner {
			width: 100%;
			box-sizing: border-box;
			margin: 20px;
		}
		.ul{
			display: flex;
		}
	    ul.no-bullet {
		    list-style: none;
			border: 1px solid;
			border-radius: 10px;
			border-color: #808080a6;
		    width: auto;
		    height: auto;
		    padding: 10%;
		    margin: 1%;
	    }
	    .inner-header{
	        background-color: #808080a6;
	        padding: 8px 20px;
	        border-bottom: 1px solid #ccc;
	        margin-top: 8px;
	        margin-right: -30px;
	        margin-bottom: 20px;
	    }
	    .inner{
	    	
	    }	    
		.touroku{
			text-align: right;
			padding: auto;
		}
		.search{
			border: 1px solid;
			border-radius: 10px;
			border-color: #808080a6;
			padding: 8px;
			display: flex;
		}
		.lab{
			width: 30%;
			margin-right: 15px;
		}
		.label{
			display: flex;
			width: 100%;
			text-align: center;
		}
		.check{
			margin: 5px;
		}
		.table{
			width: 100%;
			display: table;
			margin-left: auto;
		}
		.main-footer {
			margin: auto;
			padding: 14px 30px 12px;
			background-color: #f0f0f0;
			text-align: center;
			color: #6f7782;
			line-height: 1.4;
	        border-bottom: 1px solid #ccc;
	        margin-left: 40px;
	        margin-right: 40px;
		}
	
		.main-footer__copy {
			font-size: 15px;
		}
	
		.main-footer__school {
			font-size: 15px;
		}
	</style>
</head>
<body>
<div class="wrapper">
	<div class="sidebar">
		<div class="sidebar--inner">
			<c:if test="${not empty sessionScope.teacher}">
				<dl>
					<dt>
						<a href="../main/Menu.action">メニュー</a>
					</dt>
					<dt>
						<a href="../gakusei/StudentList.action">学生管理</a>
					</dt>
					<dt>
						成績管理
						<dd>
							<a href="../test/TestCreate.action">成績登録</a>
						</dd>
						<dd>
							<a href="../main/Menu.action">成績参照</a>
						</dd>
					</dt>
					<dt>
						<a href="../subject/SubjectList.action">科目管理</a>
					</dt>
				</dl>
	        </c:if>
		</div>
	</div>
	
		
	<div class="main-content">
