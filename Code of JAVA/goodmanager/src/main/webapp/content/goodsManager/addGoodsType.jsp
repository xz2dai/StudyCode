<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
 %>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="<%=path %>/css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
function check(){
        var typeID = document.frm.typeID.value;
		var typeName = document.frm.typeName.value;
		
		if(typeID==""){
			
			var idError = document.getElementById("idError");
			idError.innerHTML = "<font color=red>请输入类型ID</font>";
			return false;
		}
		if(typeName == ""){
			
			var nameError = document.getElementById("nameError");
			nameError.innerHTML = "<font color=red>请输入类型名称</font>";
			return false;
			
		}
		
		return true;


}


</SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">添加商品类别</SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
          <form action="<%=path %>/servlet/AddGoodsTypeServlet" method="post" onsubmit="return check()" name="frm">
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="4" >类别信息${msg}</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem>类别ID&nbsp; <font color=red>*</font></TD>
                  <TD class=gridViewItem><input class=gridViewItem type="text" name="typeID"><span id="idError"></span></TD>
                  <TD class=gridViewItem>类别名称&nbsp;<font color=red>*</font></TD>
                  <TD class=gridViewItem><input  class=gridViewItem type="text" name="typeName"><span id="nameError"></span></TD>
                </TR>
               <TR>
                  <TD class=gridViewItem >类别描述 </TD>
                  <TD class=gridViewItem colspan="3"><input size="100" class=gridViewItem type="text" name="typeDec"></TD>
                
                  
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
