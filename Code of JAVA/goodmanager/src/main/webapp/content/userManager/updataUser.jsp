<%@ page language="java" import="java.util.*,net.hunau.goodsmanager.bean.User" pageEncoding="utf-8" %>
<%@page import="net.hunau.goodsmanager.bean.Roles" %>
<%@ page import="net.hunau.goodsmanager.dao.UserDAO,net.hunau.goodsmanager.dao.rolesDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String username = request.getParameter("userName");
    int flag = 0;
    UserDAO ud = new UserDAO();
    User user = ud.getUser(username);
    if (user != null) {
        flag = user.getValidateFlag();
    }
    String userroles = "普通用户";
    rolesDAO rolesDAO = new rolesDAO();
    if (user != null) {
        userroles = rolesDAO.getRolesDesc(user.getRoles());
    }
%>
<script type="text/javascript">
    function init() {
        var flag =
        <%=user.getValidateFlag()%>
        if (flag === 1) {
            var radio1 = document.getElementById("flag_1").setAttribute("checked", "checked")
        } else if (flag === 0) {
            var radio0 = document.getElementById("flag_0").setAttribute("checked", "checked")
        }
    }
</script>
<HTML>
<HEAD>
    <TITLE>Untitled Page</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY onload="init()">
<SCRIPT type=text/javascript>
</SCRIPT>
<DIV>
    <form action='<%=path %>/servlet/UpdateUser' method='post'>
        <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
            <TR class="bg_header" height=47>
                <TD width=10><SPAN class="main_hl"></SPAN></TD>
                <TD>
                    <SPAN class="main_hl2"></SPAN>
                    <SPAN class="main_hb">编辑用户 </SPAN>
                    <SPAN class="main_hr"></SPAN>
                </TD>
                <TD class="main_rc " width=10></TD>
            </TR>
            <TR>
                <TD class="main_ls">&nbsp;</TD>
                <TD class="main_nu" vAlign=top align=middle>
                    <DIV>
                        <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all
                               border=1>
                            <TBODY>
                            <TR>
                                <TH class=gridViewHeader colspan="5">用户信息</TH>
                            </TR>
                            <TR>
                                <TD class=gridViewItem>用户名</TD>
                                <TD class=gridViewItem><input type="text" value="<%=user.getUsername()%>"
                                                              name="userName" readonly="readonly"></TD>
                                <TD class=gridViewItem>有效标识</TD>
                                <TD class=gridViewItem>

                                    <input type='radio' name='validateFlag' value='0' id="flag_0">注销
                                    <input type='radio' name='validateFlag' value='1' id="flag_1">有效
                                </TD>
                            </TR>
                            <TR>
                                <TD class=gridViewItem>密码</TD>
                                <TD class=gridViewItem><input type='text' name='password'
                                                              value='<%=user.getPassword()%>'></TD>
                                <TD class=gridViewItem>用户类型</TD>
                                <TD class=gridViewItem>
                                    <select name="roleType" style="WIDTH:45% ;color:#566984" id="roleselect">
                                        <%
                                            List<Roles> rolesList = rolesDAO.getAllRoles();
                                            for (Roles roles : rolesList) {
                                                if(roles.getId() == user.getRoles()) {
                                        %>
                                        <option value="<%=roles.getId()%>"selected ><%=roles.getRoleName()%></option>
                                        <%
                                        } else {
                                        %>
                                        <option value="<%=roles.getId()%>"><%=roles.getRoleName()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </TD>
                            </tr>
                            <TR>
                                <TD class=gridViewItem colspan="4">
                                    <input class=cmdField type="submit" value="提交">&nbsp;&nbsp;&nbsp;
                                </Td>
                            </TR>
                            </TBODY>
                        </TABLE>
                    </DIV>
                </TD>
                <TD class="main_rs"></TD>
            </TR>
            <TR class="main_fs" height=10>
                <TD class="main_lf"></TD>
                <TD class="main_fs"></TD>
                <TD class="main_rf"></TD>
            </TR>
            </TBODY>
        </TABLE>
    </form>
</DIV>
</BODY>
</HTML>
