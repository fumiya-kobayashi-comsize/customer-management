<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<h1 align="center">メニュー画面</h1>
	<hr>

	<div align="center">
		<form action="RegisterServlet" method="GET">
			<input type="submit" value="顧客情報登録">
		</form>
		<br>
		<form action="customer-list-servlet" method="POST">
			<input type="submit" value="顧客情報一覧">
		</form>
		<br>
		<form action="InquiryListServlet" method="POST">
			<input type="submit" value="問合せ情報一覧">
		</form>
		<br>
		<form action="InqulryRegisterServlet" method="GET">
			<input type="submit" value="問合せ情報登録">
		</form>
		<br>
		<form action="logout.jsp" method="POST">
			<input type="submit" value="ログアウト">
		</form>
	</div>
</body>
</html>