<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'DeparmentView.jsp' starting page</title>
    

  </head>
  <script type="text/javascript">
  	var req ;  	
  	function createXMLHttpRequest(){
  		try{
  			return new ActiveXObject("Msxml2.XMLHTTP");
  		}catch(e){}
  		try{
  			return new ActiveXObject("Microsoft.XMLHTTP");
  		}catch(e){}
  		try{
  			return new XMLHttpRequest();
  		}catch(e){}
  		alert("XMLHttpRequest无法创建!");
  		return null;
  		
  	}
  	
  	function init(v){
  		req = createXMLHttpRequest();
  		req.onreadystatechange=change;
   		req.open("post","${pageContext.request.contextPath}/depart.do",true);
  		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  		req.send("method=toList&departid="+v);
  		
  	}
  	
  	function change(){
  		if(req.readystate==4){
  			if(req.status==200){
  				var result  = req.responseText;
  				var results = result.split(";");
  				
  				var dselect = document.myform.dept;
  				var eselect = document.myform.emp;
  				
  				var departs = results[0].split(",");
  				for(i = 0;i<departs.length;i++){
  					var depart = departs[i].split(":");
  					dselect.options[i] = new Option(depart[0],depart[1]);  					
  				}
  				
  				var emps = results[1].split(",");
  				eselect.length=0;
  				for(i=0;i<emps.length;i++){
  					var emp = emps[i].split(":");
  					eselect.options[i] = new Option(emp[0],emp[1]);
  				}
  			}
  		}
  	}
  </script>
  <body onload="init('-1');">
  <form action="" name="myform">
  <select name="dept" onchange="init(this.value);">
    	
   </select>
   <select name="emp">
    	
   </select>
  </form>
    
  </body>
</html>
