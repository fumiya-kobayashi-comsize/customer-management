<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報削除確認画面</title>
</head>
<body>

	<%
		CustomerBean custmorDetail = (CustomerBean) session.getAttribute("custmorDetail");
	%>

<h1>顧客情報-削除確認画面</h1>
	<hr>
	<h2>顧客情報を削除します。よろしいですか？</h2>
	<br>

		<table>
			<tr>
				<th>顧客ID</th>
				<td><%=custmorDetail.getCustomerId()%></td>
			</tr>
			<tr>
				<th>顧客名</th>
				<td><%=custmorDetail.getCustomerName()%></td>
			</tr>
			<tr>
				<th>顧客名(かな)</th>
				<td><%=custmorDetail.getCustomerNameKana()%></td>
			</tr>
			<tr>
				<th>郵便番号</th>
				<td><%=custmorDetail.getPostalCode()%></td>
			</tr>
			<tr>
				<th>所在地</th>
				<td><%=custmorDetail.getAddress()%></td>
			</tr>
			<tr>
				<th>地区名</th>
				<td><%=custmorDetail.getAreaName()%></td>
			</tr>
			<tr>
				<th>担当者名</th>
				<td><%=custmorDetail.getContactPersonName()%></td>
			</tr>
			<tr>
				<th>担当者名(かな)</th>
				<td><%=custmorDetail.getContactPersonNameKana()%></td>
			</tr>
			<tr>
				<th>担当者電話番号</th>
				<td><%=custmorDetail.getContactPersonTel()%></td>
			</tr>
			<tr>
				<th>営業担当者情報</th>
				<td><%=custmorDetail.getUserName()%></td>
			</tr>
		</table>




	<br>

	<form action="CustomerDeleteServlet" method="POST">
		<input type="hidden" name="item_code" value="<%=custmorDetail.getCustomerId()%>">
		<input type="submit" value="削除する">
	</form>
	<br>
	<form action="customer-list.jsp" method="POST">
		<input type="submit" value="詳細表示へ">
	</form>

</body>
</html>