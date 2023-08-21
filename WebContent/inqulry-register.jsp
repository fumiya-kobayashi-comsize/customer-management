<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.InquiryBean , java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問合せ情報登録画面</title>
</head>
<header>
	<h1 style="text-align: center">問合せ情報登録画面</h1>
</header>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
<form action="InqulryRegisterServlet" method="POST" style="text-align: center">
	<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客情報：<br></td>
			<td><input type="text" name="customerInformation" size="50"><br></td>
		</tr>
		<tr>
			<td>問合せ日時：<br></td>
			<td><input type="text" name="inquiryDatetime"><br></td>
		</tr>
		<tr>
			<td>問合せ内容：<br></td>
			<td><textarea name="inquiry" rows="5" cols="50"></textarea><br></td>
		</tr>
		<tr>
			<td>回答内容：<br></td>
			<td><textarea name="inquiryAnswer" rows="5" cols="50"></textarea><br></td>
		</tr>
		<tr>
			<td>ステータス情報：<br></td>
			<td>
			<%
				List<InquiryBean>statusList
					= (List<InquiryBean>)session.getAttribute("inqulryStatusList");
			%>
			<select name="status">
			<%
				for(InquiryBean inquirybean : statusList){
			%>
			<option value="<%=inquirybean.getStatusCode()%>,<%=inquirybean.getStatusName()%>"><%=inquirybean.getStatusName()%>
			</option>
			<%
				}
			%>
			</select><br>
			</td>
		</tr>

	</table>
	<br>
	<input type="submit" value="登録する"><input type="reset" value="クリア">
	</form>
	<form action="InquiryListServlet" method="POST">
			<input type="submit" value="問合せ一覧">
		</form>
	<form action="menu.jsp" method="POST" style="text-align: center">
		<input type="submit" value="メニュー画面へ"><br>
	</form>



</body>
</html>