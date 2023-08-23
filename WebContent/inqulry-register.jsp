<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean,model.entity.InquiryBean,java.util.List"%>
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
			<td>
			<%
				List<CustomerBean>customerList
					= (List<CustomerBean>)session.getAttribute("inqulryCustomerList");
			%>
			<select name="customer">
			<%
				for(CustomerBean customerbean : customerList){
			%>
			<option value="<%=customerbean.getCustomerId()%>,<%=customerbean.getCustomerName()%>">
							<%=customerbean.getCustomerName()%>
			</option>
			<%
				}
			%>

			</td>
		</tr>
		<tr>
			<td>問合せ日時：<br></td>
			<td>
			<input type="text" name="inquiryDatetime" required
				pattern="\d{4}-\d{2}-\{2} \d{2}:\d{2}:\{2}"placeholder="yyyy-MM-dd hh:mm:ss"><br>
			</td>
		</tr>
		<tr>
			<td>問合せ内容：<br></td>
			<td><textarea name="inquirycontents" rows="5" cols="60"></textarea><br></td>
		</tr>
		<tr>
			<td>回答内容：<br></td>
			<td><textarea name="replycontents " rows="5" cols="60"></textarea><br></td>
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
			<option value="<%=inquirybean.getStatusCode()%>,<%=inquirybean.getStatusName()%>">
							<%=inquirybean.getStatusName()%>
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
	</form><br>

	<form action="InquiryListServlet" method="POST" style="text-align: center">
			<input type="submit" value="問合せ一覧">
	</form><br>

	<form action="menu.jsp" method="POST" style="text-align: center">
		<input type="submit" value="メニュー画面へ"><br>
	</form>



</body>
</html>