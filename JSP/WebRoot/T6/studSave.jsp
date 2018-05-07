<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ht.bean.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!--

	使用动作元素jsp:useBean定义一个javabean，相当于new语句
	id的值就是对象名称
	scope(范围)="page|request|session|application"4个之一
	class=类的完整路径（包名....类名）
	使用动作元素jsp:setProperty获取页面控件的值，系统自动调用set方法
	name=useBean中id的值
	property=javabean中属性名称,也可以用*替换，表示所有属性,
	所以用*号替换时，只要一个jsp:setProperty元素
	
	param=页面中的控件名称，如果控件名称与javabean的属性名称不一致时，需要使用该属性转换
	value="指定一个固定的值";
	<jsp:getProperty name="stud" property="studId"/>
	name=useBean中id的值
	property=javabean中属性名称,不能用*号
-->
<%
	//Student s = new Student();
	//s.setStudId(Integer.parseInt(request.getParameter("studId").trim()));
 %>
<jsp:useBean id="stud" scope="session" class="ht.bean.Student">
	<jsp:setProperty name="stud" property="studId" param="studid"/>
	<jsp:setProperty name="stud" property="studName"/>
	<jsp:setProperty name="stud" property="sex"/>
	<jsp:setProperty name="stud" property="className" value="1701班"/>
	<jsp:setProperty name="stud" property="*"/>
	
</jsp:useBean>
	<jsp:setProperty name="stud" property="age"/>
	<jsp:setProperty name="stud" property="hobbit"/>
	<jsp:setProperty name="stud" property="marray"/>

学号：<jsp:getProperty name="stud" property="studId"/><br/><br/>
姓名：<jsp:getProperty name="stud" property="studName"/><br/><br/>
性别：<jsp:getProperty name="stud" property="sex"/><br/><br/>
年龄：<jsp:getProperty name="stud" property="age"/><br/><br/>
婚姻状况：<jsp:getProperty name="stud" property="marray"/><br/><br/>
兴趣爱好：<jsp:getProperty name="stud" property="hobbit"/><br/><br/>
所在班级：<jsp:getProperty name="stud" property="className"/>
<hr/>
学号：<%=stud.getStudId() %><br/><br/>
姓名：<%=stud.getStudName() %><br/><br/>
性别：<%=stud.getSex() %><br/><br/>
年龄：<%=stud.getAge() %><br/><br/>
婚姻状况：<%=stud.isMarray() %><br/><br/>
兴趣爱好：

<%
String ho[] = stud.getHobbit();
String str="";
for(int i=0;i<ho.length;i++){
	str += ho[i]+",";
}
%>
<%=str %>
<br/><br/>
所在班级：<%=stud.getClassName()%>


