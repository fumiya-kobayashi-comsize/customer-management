<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.InquiryBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問合せ情報-登録成功画面</title>
</head>

<header>
	<h1 align="center">問合せ情報登録完了画面</h1><br>
</header>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>

<body>

		<hr>
<h1 align="center">問合せ情報を登録完了致しました。</h1>
<%InquiryBean inqulryregisterBean = (InquiryBean)session.getAttribute("inqulryregisterBean"); %>
<table border="1" class="table" style="text-align: left">

		<tr>
			<td>顧客情報：<br></td>
			<td><%=inqulryregisterBean.getCustomerId() %></td>
		</tr>

		<tr>
			<td>問合せ日時：<br></td>
			<td><%=inqulryregisterBean.getInquiryDatetime()%><br></td>
		</tr>

		<tr>
			<td>問合せ内容：<br></td>
			<td><%=inqulryregisterBean.getInquiryContents()%><br></td>
		</tr>

		<tr>
			<td>回答内容：<br></td>
			<td><%=inqulryregisterBean.getReplyContents()%><br></td>
		</tr>

		<tr>
			<td>ステータス情報：<br></td>
			<td><%=inqulryregisterBean.getStatusName()%><br></td>
		</tr>


	</table><br>

</body>
</html>