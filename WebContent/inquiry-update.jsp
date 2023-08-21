<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.InquiryBean, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問合せ情報編集画面</title>
</head>
<header>
	<h1 style="text-align: center">問合せ情報編集画面</h1>
</header>
<style>
.table{
    margin: auto;
    width: 600px;
}
</style>
<body>
<hr>
	<h1 align="center">問合せ情報を編集します。</h1>

<%InquiryBean inquiryBean = (InquiryBean)session.getAttribute("inquiryDetailBean"); %>

	<form action="InquiryUpdateServlet" method="POST" style="text-align: center">
	<table border="1" class="table" style="text-align: left">
		<tr>
			<td>顧客情報：<br></td>
			<td>
				<%=inquiryBean.getCustomerName() %>
				<input type="hidden" name="inquiryId" value=<%=inquiryBean.getInquiryId()%>><br>
			</td>
		</tr>
		<tr>
			<td>問合せ日時：<br></td>
			<td><textarea rows="1" cols="60" name= "inquiryDatetime"><%=inquiryBean.getInquiryDatetime()%></textarea><br></td>
		</tr>
		<tr>
			<td class="inquiryContents">問合せ内容：<br></td>
			<td><textarea rows="5" cols="60" name= "inquiryContents"><%=inquiryBean.getInquiryContents()%></textarea><br></td>
		</tr>
		<tr>
			<td class="replyContents">回答内容：<br></td>
			<td><textarea rows="5" cols="60" name= "replyContents"><%=inquiryBean.getReplyContents()%></textarea><br></td>
		</tr>
		<tr>
			<td>ステータス情報：<br></td>
			<td><input type="text" name="statusName" value=<%=inquiryBean.getStatusName()%> required>
			<input type="hidden" name="statusCode" value=<%=inquiryBean.getStatusCode()%>><br>
			<br></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="編集する"><input type="reset" value="クリア">
	</form>

	<div align="center">
	<form action ="inquiry-list.jsp" method ="POST">
		<input type ="submit" value ="問合せ一覧に戻る">
	</form>
	</div>

</body>
</html>