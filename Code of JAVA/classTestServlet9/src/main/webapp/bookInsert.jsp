<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html><head> <title>Book Insert</title>
</head>
<body>
<h3>请输入图书信息：</h3>
<% if(request.getAttribute("result")!=null)
    out.print(request.getAttribute("result"));
%>
<form action = "BookInsertServlet" method = "post">
    <table>
        <tr><td>书号</td> <td><input type="text" name="bookid" ></td></tr>
        <tr><td>书名</td><td><input type="text" name="title"></td></tr>
        <tr><td>作者</td><td><input type="text" name="author" ></td></tr>
        <tr><td>出版社</td><td><input type="text" name="publisher" ></td></tr>
        <tr><td>单价</td><td><input type="text" name="price" ></td></tr>
        <tr><td><input type="submit" value="确定" ></td>
            <td><input type="reset" value="重置" ></td>
        </tr>
    </table>
</form>
</body></html>
