<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.InquiryBean, java.util.List,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問合せ情報編集失敗画面</title>
</head>
<header>
	<h1 style="text-align: center">問合せ情報編集失敗画面</h1>
</header>
<style>
.table{
    margin: auto;
    width: 600px;
}
</style>
<body>
<hr>
	<h1 align="center">以下の問合せ情報の編集失敗しました。</h1>
<%InquiryBean inquiryBean = (InquiryBean)session.getAttribute("inquiryUpdateBean"); %>
	<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客情報：<br></td>
			<td><%=inquiryBean.getCustomerName() %></td>
		</tr>
		<tr>
			<td>問合せ日時：<br></td>
			<%SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String formattedDate = dateFormat.format(inquiryBean.getInquiryDatetime()); %>
			<td><%=formattedDate%></td>
		</tr>
		<tr>
			<td>問合せ内容：<br></td>
			<td><%=inquiryBean.getInquiryContents() %></td>
		</tr>
		<tr>
			<td>回答内容：<br></td>
			<td><%=inquiryBean.getReplyContents() %></td>
		</tr>
		<tr>
			<td>ステータス情報：<br></td>
			<td><%=inquiryBean.getStatusName() %></td>
		</tr>
	</table><br>
	<div align="center">
	<form action ="InquiryListServlet" method ="POST">
		<input type ="submit" value ="問合せ一覧に戻る">
	</form>
	<form action ="menu.jsp" method ="POST">
		<input type ="submit" value ="メニューに戻る">
	</form>
	</div>
</body>

</html>