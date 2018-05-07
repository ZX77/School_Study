<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>简易计算器</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.num1.value==""){
    			alert("请输入数字1");
    			form1.num1.focus();
    			return false;
    		}
    		if(isNaN(form1.num1.value)){
    			alert("数字1含有非法字符");
    			form1.num1.focus();
    			return false;
    		}
    		if(form1.num2.value==""){
    			alert("请输入数字2");
    			form1.num2.focus();
    			return false;
    		}
    		if(isNaN(form1.num2.value)){
    			alert("数字2含有非法字符");
    			form1.num2.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">简易计算器</h1>
    <hr/>
    <jsp:useBean id="calc" scope="request" class="ht.bean.Calc">
    	<jsp:setProperty name="calc" property="*"/>
    </jsp:useBean>
    <jsp:getProperty name="calc" property="num1"/>
    <jsp:getProperty name="calc" property="opr"/>
    <jsp:getProperty name="calc" property="num2"/>
    =
    <jsp:getProperty name="calc" property="result"/>
    <hr/>
    <form name="form1" action="<%=basePath%>T6/job/calc.jsp" method="post" onsubmit="return check();">
    	<input type="text" name="num1" value="<%=calc.getNum1() %>">
    	<select name="opr">
    		<option value="+">加</option>
    		<option value="-">减</option>
    		<option value="*">乘</option>
    		<option value="/">除</option>
    	</select>
    	<input type="text" name="num2" value="<%=calc.getNum2() %>">
    	<input type="submit" value="  =  ">
    	<input type="text" name="result" value="<%=calc.getResult() %>">
    	
    </form>
  </body>
</html>
