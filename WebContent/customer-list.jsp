<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報一覧表示画面</title>
</head>
<body>

<h1 align="center">顧客情報一覧表示画面</h1><br>
	<hr>

	<table border="1" align="center">
	<tr>
	<th>顧客ID</th>
	<th>顧客名</th>
	<th>顧客名(かな)</th>
	<th>郵便番号</th>
	<th>所在地</th>
	<th>地区名</th>
	<th>担当者名</th>
	<th>担当者名(かな)</th>
	<th>担当者電話番号</th>
	<th>営業担当者情報</th>
	</tr>

	<%
	List<CustomerBean> customerList
			= (List<CustomerBean>) session.getAttribute("customerList");

		for(CustomerBean customerbean : customerList){
	%>
			<tr>
			<td><%=customerbean.getCustomerId()%></td>
			<td><%=customerbean.getCustomerName()%></td>
			<td><%=customerbean.getCustomerNameKana()%></td>
			<td><%=customerbean.getPostalCode()%></td>
			<td><%=customerbean.getAddress()%></td>
			<td><%=customerbean.getAreaName()%></td>
			<td><%=customerbean.getContactPersonName()%></td>
			<td><%=customerbean.getContactPersonNameKana()%></td>
			<td><%=customerbean.getContactPersonTel()%></td>
			<td><%=customerbean.getUserName()%></td>

			<td>
				<form action ="custemer-detail-servlet" method ="POST">
				<input type ="submit" value ="編集">
				<input type ="hidden" name ="CustomerId" value = "<%=customerbean.getCustomerId()%>">
				</form>
			</td>
			<td>
				<form action ="CustomerDeleteServlet" method ="POST">
				<input type ="submit" value ="削除">
				<input type ="hidden" name ="CustomerId" value = "<%=customerbean.getCustomerId()%>">
				</form>
			</td>

		<%}%>
	</tr>
	</table><br>

	<div align="center">
	<form action ="menu.jsp" method ="POST">
		<div align="center">
		<input type ="submit" value ="メニュー画面へ">
		</div>
	</form>
	</div>


</body>
</html>