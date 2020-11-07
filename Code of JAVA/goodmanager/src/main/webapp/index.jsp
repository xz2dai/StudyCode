<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="org.w3c.dom.Document" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String errorMessage = (String) request.getAttribute("errorMessage");
    if(errorMessage == null) errorMessage="";
%>
<script type="text/javascript">
    function checkempty(){
        var input_name = document.getElementById("userName");
        var input_pwd = document.getElementById("password")
        if(input_name.value == ""){
            alert("请输入用户名！");
            input_name.focus();
            return false;
        }
        if(input_pwd.value == ""){
            alert("请输入密码！");
            input_pwd.focus();
            return false;
        }
        return true;

    }
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>欢迎登陆商品管理系统</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="css/public.css" type=text/css rel=stylesheet>
    <LINK href="css/login.css" type=text/css rel=stylesheet>


</HEAD>
<BODY>
<DIV id=div1>
    <TABLE id=login style="width: 800px;height: 100%;" align="center">
        <TBODY>
        <TR id=main>
            <TD>
                <form action="LoginServlet" method='post' onsubmit='return checkempty()'>
                    <TABLE style="height: 100%;width: 100%">
                        <TBODY>
                        <TR>
                            <TD colSpan=4>&nbsp;</TD>
                        </TR>
                        <TR style="height: 30px">
                            <TD style="width: 380px">&nbsp;</TD>
                            <TD>&nbsp;</TD>
                            <TD>&nbsp;</TD>
                            <TD>&nbsp;</TD>
                        </TR>
                        <TR height=40>
                            <TD rowSpan=4></TD>
                            <TD>用户名：</TD>
                            <TD>
                                <label for="userName"></label><INPUT class=textbox id="userName" name="userName">
                            </TD>
                            <TD style="width: 120px">&nbsp;</TD>
                        </TR>
                        <TR height=40>
                            <TD>密　码：</TD>
                            <TD>
                                <label for="password"></label><INPUT class=textbox id="password" type=password
                                                                     name="password">
                            </TD>
                            <TD style="width: 120px;">&nbsp;</TD>
                        </TR>
                        <TR height=40>
                            <TD><!-- 验证码：--></TD>
                            <TD colSpan=2>
                                <!-- <INPUT id=txtSN size=4 name=txtSN> &nbsp; <IMG src="images/default.gif" border=0> <A id=LinkButton1 href="#">不清楚，再来一张</A>-->
                                <p id="errormessage">
                                    <span style="color: red;">
                                        <%=errorMessage%>
                                    </span>
                                </p>
                            </TD>
                        </TR>
                        <TR height=40>
                            <TD></TD>
                            <TD align=right>
                                <INPUT id=btnLogin type=submit value=" 登 录 ">
                            </TD>
                            <TD style="width: 120px">&nbsp;</TD>
                        </TR>
                        <TR height=110>
                            <TD colSpan=4>&nbsp;</TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                </form>
            </TD>
        </TR>
        <TR id=root height=104>
            <TD>&nbsp;</TD>
        </TR>
        </TBODY>
    </TABLE>
</DIV>
<DIV id=div2 style="DISPLAY: none"></DIV>

</BODY>
</HTML>
