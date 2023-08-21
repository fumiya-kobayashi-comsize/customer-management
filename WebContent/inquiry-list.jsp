<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.InquiryBean, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問合せ情報一覧画面</title>
</head>
<header>
	<h1 style="text-align: center">問合せ情報一覧画面</h1>
</header>
<style>
.table{
    margin: auto;
    width: 540px;
}
</style>
<body>
	<hr>

	<table border="1" style="text-align: left" class="table">
	<tr>
		<th>顧客情報</th>
		<th>問合せ日時</th>
		<th>問合せ内容</th>
		<th>回答内容</th>
		<th>ステータス情報</th>
	</tr>

	<%
	List<InquiryBean> inquiryList
			= (List<InquiryBean>) session.getAttribute("inquiryList");

		for(InquiryBean inquiryBean : inquiryList){
	%>
			<tr>
			<td><%=inquiryBean.getCustomerName()%></td>
			<td><%=inquiryBean.getInquiryDatetime()%></td>
			<td><%=inquiryBean.getInquiryContents()%></td>
			<td><%=inquiryBean.getReplyContents()%></td>
			<td><%=inquiryBean.getStatusName()%></td>
			<td>
				<form action ="InquiryDetailServlet" method ="POST">
				<input type ="submit" value ="編集">
				<input type ="hidden" name ="CustomerId" value = "<%=inquiryBean.getInquiryId()%>">
				</form>
			</td>
			<td>
				<form action ="inquiry-delete.jsp" method ="POST">
				<input type ="submit" value ="削除">
				<input type ="hidden" name ="CustomerId" value = "<%=inquiryBean.getInquiryId()%>">
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