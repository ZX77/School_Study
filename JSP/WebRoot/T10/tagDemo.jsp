<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="demo" uri="/demotag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>自定义标签的使用</title>
  </head>
  
  <body>
    <h2 align="center">自定义标签的使用</h2>
    <h3>调用实现Tag接口的的空标签</h3>
    <demo:hello/>
    <demo:hello/>
    <h3>调用继承TagSupport类的非空标签</h3>
    <demo:helloSupport>张三</demo:helloSupport>
    <demo:helloSupport>小丽</demo:helloSupport>
    <h3>调用继承BodyTagSupport类的if标签</h3>
    <demo:if counts="0">条件为假，不打印</demo:if>
    <demo:if counts="1">条件为真，显示该行内容</demo:if>
    <h3>调用继承BodyTagSupport类的for标签</h3>
    <demo:for count="5">
    aaaaa
    </demo:for>
    <h3 align="center">用户资料列表标签</h3>
    <demo:user align="center" bgcolor="pink"></demo:user>
  </body>
</html>
