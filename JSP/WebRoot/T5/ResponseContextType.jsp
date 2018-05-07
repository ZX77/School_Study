<%@ page  contentType="text/html;charset=GB2312" %>

<html>
<head>
  <title>ResponseContextType.jsp</title>
</head>
<body>

<%
    String type=request.getParameter("type");
	if(type==null){
%>
<form action="ResponseContextType.jsp" method="post">

    请选择文件显示的方式：<br/>
		<input type="radio" name="type" value="word" checked>word<br>
		<input type="radio" name="type" value="excel" >excel<br>
		<input type="radio" name="type" value="html" >html<br>

		<input type="submit" name="submit" value="确定">
</form>
<%
	}else{
	    if(type.equals("word")){
		    response.setContentType("application/msword;charset=gb2312");
		}else  if(type.equals("excel")){
		    response.setContentType("application/x-msexcel;charset=gb2312");
		}else  if(type.equals("html")){
		    response.setContentType("text/html;charset=gb2312");
		}
%>
  <jsp:include page="data.txt"/>
<%
	}			
%>
</body>
</html>