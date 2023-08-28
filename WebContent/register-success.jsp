<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報登録完了画面</title>
</head>
<header>
	<h1 align="center">顧客情報登録完了画面</h1><br>
</header>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
		<hr>
<h1 align="center">顧客情報を登録完了致しました。</h1>
<%CustomerBean registerBean = (CustomerBean)session.getAttribute("registerBean"); %>
<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客ID：<br></td>
			<td><%=registerBean.getCustomerId() %></td>
		</tr>
		<tr>
			<td>顧客名称：<br></td>
			<td><%=registerBean.getCustomerName()%><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：<br></td>
			<td><%=registerBean.getCustomerNameKana()%><br></td>
		</tr>
		<tr>
			<td>郵便番号：<br></td>
			<td><%=registerBean.getPostalCode()%><br></td>
		</tr>
		<tr>
			<td>所在地：<br></td>
			<td><%=registerBean.getAddress()%><br></td>
		</tr>
		<tr>
			<td>地区情報：<br></td>
			<td><%=registerBean.getAreaName()%><br></td>
		</tr>
		<tr>
			<td>担当者名：<br></td>
			<td><%=registerBean.getContactPersonName()%><br></td>
		</tr>
		<tr>
			<td>担当者かな：<br></td>
			<td><%=registerBean.getContactPersonNameKana()%><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：<br></td>
			<td><%=registerBean.getContactPersonTel()%><br></td>
		</tr>
		<tr>
			<td>営業担当者情報：<br></td>
			<td><%=registerBean.getUserName()%><br></td>
		</tr>
	</table><br>
	<form action="menu.jsp" method="POST" style="text-align: center">
			<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>