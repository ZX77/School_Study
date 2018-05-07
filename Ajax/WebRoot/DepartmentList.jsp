<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>  AjaxDemo </title>
    

  </head>
  
  <script>
  var req;
  var x,y;
  	function createXMLHttpRequest(){
  		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e){}
		try{
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(e){}
		try{
			return new XMLHttpRequest();
		}
		catch(e){}
		alert("无法创建XMLHttpRequest 。。。");
		return null;
		
  	}
  	function init(){
  		
  		req = createXMLHttpRequest();
  		req.onreadystatechange=change;
  		req.open("post","${pageContext.request.contextPath}/depart.do",true);
  		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  		req.send("method=findAllDepart");
  		
  	}
  	
  	function change(){
  		if(req.readystate==4){
  			if(req.status==200){
  				var str = req.responseText;
  				var departs = str.split(",");
  				var content = "";
  				for(i=0;i<departs.length;i++){
  					var depart = departs[i].split(":");
  					var row = myTab.insertRow();
  					var cell = row.insertCell();
  					cell.innerHTML="<div onMouseOver=show('"+depart[1]+"') onMouseOut=javascript:myDiv.style.display='none';>"+depart[0]+"</div>";
  				}
  			}
  		}
  	}
  	
  	function show(id){
  		x = event.x;
  		y = event.y;
  		req = createXMLHttpRequest();
  		req.onreadystatechange=showDepart;
  		req.open("post","${pageContext.request.contextPath}/depart.do",true);
  		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  		req.send("method=findDepartById&departid="+id);
  		
  	}
  	
  	function showDepart(){
  		if(req.readystate==4){
  			if(req.status==200){
  				var  str = req.responseText;
  				var depart = str.split(":");
  				var str_depart="部门名称:"+depart[0]+"<br>部门地址:"+depart[1]+"<br>部门电话:"+depart[2]+"<br>部门邮编:"+depart[3];
  				
  				myDiv.innerHTML=str_depart;
  				myDiv.style.left=x+"px";
  				myDiv.style.top=y+"px";
  				myDiv.style.display='inline';
  				
  			}	
  		}
  	}
  </script>
  <body onLoad="init();">
    	<table id="myTab" border="1" >
    		
    	</table>
    	<div id="myDiv" style=" position:absolute; left:10px; top:10px; z-index:1; background-color: #9966FF; display:none "></div>
  </body>
</html>
