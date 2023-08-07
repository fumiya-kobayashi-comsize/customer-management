<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean, model.entity.UserBean, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報編集画面</title>
</head>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
<h1 align="center">顧客情報編集画面</h1><br>
	<hr>
<h1 align="center">顧客情報を編集します。</h1>

<%CustomerBean detailbean = (CustomerBean)session.getAttribute("detailbean"); %>

	<form action="CustomerUpdateServlet" method="POST" style="text-align: center">
	<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客ID：<br></td>
			<td>
				<%=detailbean.getCustomerId() %>
				<input type="hidden" name="customerId" value=<%=detailbean.getCustomerId()%>><br>
			</td>
		</tr>
		<tr>
			<td>顧客名称：<br></td>
			<td><input type="text" name="customerName" value=<%=detailbean.getCustomerName()%> size="50"><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：<br></td>
			<td><input type="text" name="customerNameKana" value=<%=detailbean.getCustomerNameKana()%> size="50"><br></td>
		</tr>
		<tr>
			<td>郵便番号：<br></td>
			<td class="postal"><input type="text" name="postalCode" value=<%=detailbean.getPostalCode()%> size="8" placeholder="XXX-XXXX"><br></td>
		</tr>
		<tr>
			<td>所在地：<br></td>
			<td><input type="text" name="address" value=<%=detailbean.getAddress()%> size="50"><br></td>
		</tr>
		<tr>
			<td>地区情報：<br></td>
			<td>
			<%
				List<CustomerBean>areaList
					= (List<CustomerBean>)session.getAttribute("areaList");
			%>

			<select name="area">
			<%
				for(CustomerBean areabean : areaList){
			%>
			<option value="<%=areabean.getAreaCode()%>,<%=areabean.getAreaName()%>"><%=areabean.getAreaName()%>
			</option>
			<%
				}
			%>
			</select>
			</td>
		</tr>
		<tr>
			<td>担当者名：<br></td>
			<td><input type="text" name="contactPersonName" value=<%=detailbean.getContactPersonName()%> size="50"><br></td>
		</tr>
		<tr>
			<td>担当者かな：<br></td>
			<td><input type="text" name="contactPersonNameKana" value=<%=detailbean.getContactPersonNameKana()%> size="50"><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：<br></td>
			<td><input type="text" name="contactPersonTel" value=<%=detailbean.getContactPersonTel()%> size="50"><br></td>
		</tr>
		<tr>
			<td>営業担当者情報：<br></td>
			<td>
			<%
				List<UserBean>userList
					= (List<UserBean>)session.getAttribute("userList");
			%>
			<select name="user">
			<%
				for(UserBean userbean : userList){
			%>
			<option value="<%=userbean.getUserId()%>,<%=userbean.getUserName()%>"><%=userbean.getUserName()%>
			</option>
			<%
				}
			%>
			</select>
			</td>
	</table>
	<br>
	<input type="submit" value="編集する"><input type="reset" value="クリア">
	</form>
</body>
</html>