<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除失敗画面</title>
</head>
<body>

<h1 align="center">顧客情報-削除確認画面</h1>
	<hr>

	<%
		CustomerBean customerResult = (CustomerBean) session.getAttribute("custmorDetail");
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
	%>



	<h1 align="center">次のデータを削除できませんでした。</h1>

	<br>
	<br>
	<table>
			<tr>
				<th>顧客ID</th>
				<td><%=customerResult.getCustomerId()%></td>
			</tr>
			<tr>
				<th>顧客名</th>
				<td><%=customerResult.getCustomerName()%></td>
			</tr>
			<tr>
				<th>顧客名(かな)</th>
				<td><%=customerResult.getCustomerNameKana()%></td>
			</tr>
			<tr>
				<th>郵便番号</th>
				<td><%=customerResult.getPostalCode()%>円</td>
			</tr>
			<tr>
				<th>所在地</th>
				<td><%=customerResult.getAddress()%></td>
			</tr>
			<tr>
				<th>地区名</th>
				<td><%=customerResult.getAreaName()%></td>
			</tr>
			<tr>
				<th>担当者名</th>
				<td><%=customerResult.getContactPersonName()%></td>
			</tr>
			<tr>
				<th>担当者名(かな)</th>
				<td><%=customerResult.getContactPersonNameKana()%></td>
			</tr>
			<tr>
				<th>担当者電話番号</th>
				<td><%=customerResult.getContactPersonTel()%>円</td>
			</tr>
			<tr>
				<th>営業担当者情報</th>
				<td><%=customerResult.getUserName()%></td>
			</tr>
		</table>
	<%
		}
	%>



	<div align="center">
		<form action="customer-delete-confirm.jsp" method="POST">
			<input type="submit" value="詳細表示へ">
		</form>
	</div>



</body>
</html>