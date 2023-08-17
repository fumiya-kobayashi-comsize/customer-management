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
				<input type="hidden" name="customerId" value=<%=detailbean.getCustomerId()%> required><br>
			</td>
		</tr>
		<tr>
			<td>顧客名称：<br></td>
			<td><input type="text" size="50" name="customerName" value=<%=detailbean.getCustomerName()%> required><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：<br></td>
			<td><input type="text" size="50" name="customerNameKana" value=<%=detailbean.getCustomerNameKana()%>><br></td>
		</tr>
		<tr>
			<td>郵便番号：<br></td>
			<td class="postal"><input type="text" name="postalCode" value=<%=detailbean.getPostalCode()%> pattern="\d{3}-\d{4}" placeholder="XXX-XXXX"><br></td>
		</tr>
		<tr>
			<td>所在地：<br></td>
			<td><input type="text" size="50" name="address" value=<%=detailbean.getAddress()%>><br></td>
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
			<td><input type="text" size="50" name="contactPersonName" value=<%=detailbean.getContactPersonName()%>><br></td>
		</tr>
		<tr>
			<td>担当者かな：<br></td>
			<td><input type="text" size="50" name="contactPersonNameKana" value=<%=detailbean.getContactPersonNameKana()%>><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：<br></td>
			<td><input type="text" size="50" name="contactPersonTel" value=<%=detailbean.getContactPersonTel()%>><br></td>
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

	<div align="center">
	<form action ="customer-list.jsp" method ="POST">
		<input type ="submit" value ="一覧に戻る">
	</form>
	</div>

</body>
</html>