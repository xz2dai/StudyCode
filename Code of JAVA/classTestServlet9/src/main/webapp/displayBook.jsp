<%@ page import="MyServlet.Beans.BookBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:useBean id="book" class="MyServlet.Beans.BookBean" scope="application" />
<html>
<body>
<table>
    <tr>
        <td>书号:</td>
        <td>
            <jsp:getProperty name="book" property="bookid"/>
        </td>
    </tr>
    <tr>
        <td>书名:</td>
        <td>
            <jsp:getProperty name="book" property="title"/>
        </td>
    </tr>
    <tr>
        <td>作者:</td>
        <td>
            <jsp:getProperty name="book" property="author"/>
        </td>
    </tr>
    <tr>
        <td>出版社:</td>
        <td>
            <jsp:getProperty name="book" property="publisher"/>
        </td>
    </tr>
    <tr>
        <td>价格:</td>
        <td>
            <jsp:getProperty name="book" property="price"/>
        </td>
    </tr>
</table>
</body>
</html>
