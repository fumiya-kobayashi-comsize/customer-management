<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean, model.entity.UserBean, java.util.List"%>
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
			<td><input type="text" name="customerName" size="50" required><br></td>
		</tr>
		<tr>
			<td>顧客名称かな：<br></td>
			<td><input type="text" name="customerNameKana" size="50" required><br></td>
		</tr>
		<tr>
			<td>郵便番号：<br></td>
			<td class="postal"><input type="text" name="postalCode" pattern="\d{3}-\d{4}"placeholder="XXX-XXXX" required = "-"><br></td>
		</tr>
		<tr>
			<td>所在地：<br></td>
			<td><input type="text" name="address" size="50" required><br></td>
		</tr>
		<tr>
			<td>地区情報：<br></td>
			<td>
			<%
				List<CustomerBean>areaList
					= (List<CustomerBean>)session.getAttribute("registerAreaList");
			%>
			<select name="area">
			<%
				for(CustomerBean areabean : areaList){
			%>
			<option value="<%=areabean.getAreaCode()%>,<%=areabean.getAreaName()%>" required><%=areabean.getAreaName()%>
			</option>
			<%
				}
			%>
			</select>
			<br></td>
		</tr>
		<tr>
			<td>担当者名：<br></td>
			<td><input type="text" name="contactPersonName" size="50" required><br></td>
		</tr>
		<tr>
			<td>担当者かな：<br></td>
			<td><input type="text" name="contactPersonNameKana" size="50" required><br></td>
		</tr>
		<tr>
			<td>担当者電話番号：<br></td>
			<td><input type="text" name="contactPersonTel" size="50" required><br></td>
		</tr>
		<tr>
			<td>営業担当者情報：<br></td>
			<td>
			<%
				List<UserBean>userList
					= (List<UserBean>)session.getAttribute("registerUserList");
			%>
			<select name="user">
			<%
				for(UserBean userbean : userList){
			%>
			<option value="<%=userbean.getUserId()%>,<%=userbean.getUserName()%>" required><%=userbean.getUserName()%>
			</option>
			<%
				}
			%>
			</select><br>
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="登録する"><input type="reset" value="クリア"><br>
	</form>
	<form action="customer-list.jsp" method="POST" style="text-align: center">
		<input type="submit" value="顧客情報一覧へ"><br>
	</form>
	<form action="menu.jsp" method="POST" style="text-align: center">
		<input type="submit" value="メニュー画面へ"><br>
	</form>
</body>
</html>