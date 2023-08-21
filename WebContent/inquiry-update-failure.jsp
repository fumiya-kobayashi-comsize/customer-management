<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%InquiryBean inquiryBean = (InquiryBean)session.getAttribute("inquiryDetailBean"); %>
</body>
</html>