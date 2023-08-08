<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報編集エラー画面</title>
</head>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
<h1 align="center">顧客情報編集エラー画面</h1><br>
	<hr>
<h1 align="center">顧客情報を編集できませんでした。</h1>
<%CustomerBean updatebean = (CustomerBean)session.getAttribute("updatebean"); %>
<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客ID：</td>
			<td><%=updatebean.getCustomerId() %><br></td>
		</tr>
		<tr>
			<td>顧客名称：</td>
			<td><%=updatebean.getCustomerName()%><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：</td>
			<td><%=updatebean.getCustomerNameKana()%><br></td>
		</tr>
		<tr>
			<td>郵便番号：</td>
			<td><%=updatebean.getPostalCode()%><br></td>
		</tr>
		<tr>
			<td>所在地：</td>
			<td><%=updatebean.getAddress()%><br></td>
		</tr>
		<tr>
			<td>地区情報：</td>
			<td><%=updatebean.getAreaName()%><br></td>
		</tr>
		<tr>
			<td>担当者名：</td>
			<td><%=updatebean.getContactPersonName()%><br></td>
		</tr>
		<tr>
			<td>担当者かな：</td>
			<td><%=updatebean.getContactPersonNameKana()%><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：</td>
			<td><%=updatebean.getContactPersonTel()%><br></td>
		</tr>
		<tr>
			<td>営業担当者情報：</td>
			<td><%=updatebean.getUserName()%><br></td>
		</tr>
	</table>

</body>
</html>