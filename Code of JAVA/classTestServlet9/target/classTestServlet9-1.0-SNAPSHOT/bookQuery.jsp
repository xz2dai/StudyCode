<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head><title>图书查询</title></head>
<body>
<form action="BookQueryServlet2" method="post">
    请输入书号：
    <input type="text" name="bookid" size="15">
    <input type="submit" value="确定">
</form>
<p><a href="BookQueryServlet">查询所有图书</a></p>
</body>
</html>
