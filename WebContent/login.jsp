<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<h1 align="center">ログイン画面</h1>
	<hr>
	<h1 align="center">
		<b>ユーザIDとパスワードを入力してください</b>
	</h1>

	<form action="LoginServlet" method="POST">
		<table align="center">
			<tr>
				<th>ユーザID</th>
				<td><input type="text" name="userId">
				<td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="password">
				<td><br>
			</tr>
		</table>
	<br>
	<div align="center">
	<input type="submit" value="ログイン">
	<input type="reset" value="取消">
	</div>

	</form>



</body>
</html>