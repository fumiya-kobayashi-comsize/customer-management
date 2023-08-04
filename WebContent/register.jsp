<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報登録画面</title>
</head>
<header>
	<h1 style="text-align: center">顧客情報登録画面</h1>
</header>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
	<form action="RegisterServlet" method="POST" style="text-align: center">
	<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客名称：<br></td>
			<td><input type="text" name="customerName" size="50"><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：<br></td>
			<td><input type="text" name="customerNameKana" size="50"><br></td>
		</tr>
		<tr>
			<td>郵便番号：<br></td>
			<td class="postal"><input type="text" name="postalCode" size="8" placeholder="XXX-XXXX"><br></td>
		</tr>
		<tr>
			<td>所在地：<br></td>
			<td><input type="text" name="address" size="50"><br></td>
		</tr>
		<tr>
			<td>地区情報：<br></td>
			<td><input type="text" name="areaCode" size="50"><br></td>
		</tr>
		<tr>
			<td>担当者名：<br></td>
			<td><input type="text" name="contactPersonName" size="50"><br></td>
		</tr>
		<tr>
			<td>担当者かな：<br></td>
			<td><input type="text" name="contactPersonNameKana" size="50"><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：<br></td>
			<td><input type="text" name="contactPersonTel" size="50"><br></td>
		</tr>
		<tr>
			<td>営業担当者情報：<br></td>
			<td><input type="text" name="userId" size="50"><br></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="登録する"><input type="reset" value="クリア">
	</form>
</body>
</html>