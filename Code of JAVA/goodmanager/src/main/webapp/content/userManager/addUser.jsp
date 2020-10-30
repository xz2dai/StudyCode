<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="net.hunau.goodsmanager.bean.Roles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();

 %>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>

<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">添加用户 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
		  <form action="<%=path %>/servlet/AddUserServlet"  onsubmit="return check()">
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="4" >用户信息</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem>用户名 <font color="red">*</font></TD>
                  <TD class=gridViewItem><input class=gridViewItem type="text" id="userName" name="userName"></TD>
                  <TD class=gridViewItem >用户类型 </TD>
                  <TD class=gridViewItem>
						<select name="roleType" style="WIDTH:45% ;color:#566984" >
						
						<option value="####">####</option>  
					
						</select>  
				  </TD>
                </TR>
               <TR>
                  <TD class=gridViewItem >密码&nbsp;<font color="red">*</font> </TD>
                  <TD class=gridViewItem><input  class=gridViewItem type="password" id="passWord" name="passWord"></TD>
                  <TD class=gridViewItem>确认密码&nbsp;<font color="red">*</font></TD>
                  <TD class=gridViewItem><input   class=gridViewItem type="password" id="repassword" name="repassword"></TD>
                </TR>
  
                <TR>
                  <TD class=gridViewItem  colspan="4" >
                <input class=cmdField type="submit" value="提交">&nbsp;&nbsp;&nbsp;<input class=cmdField type="reset">
                  </Td>
                </TR>
              </TBODY>
            </TABLE>
            </form>
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
</DIV>
</BODY>
</HTML>
