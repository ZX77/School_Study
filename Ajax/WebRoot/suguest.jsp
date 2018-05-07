<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->

var req;
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
	var name = document.frm.name.value;
	req = createXMLHttpRequest();
	req.onreadystatechange=change;
	req.open("post","${pageContext.request.contextPath}/depart.do",false);
	req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  	req.send("method=searchDepart&departName="+name);
}

function change(){
	if(req.readystate==4){
		if(req.status==200){
			var str = req.responseText;
			var departs = str.split(",");
			n=wordsListTable.rows.length-1;
			for(;n>=0;n--){
				wordsListTable.deleteRow(n);
			}
			for(i=0;i<departs.length;i++){
				var row = wordsListTbody.insertRow();
				var cell = row.insertCell();
				cell.innerHTML=departs[i];
			}
		}
	}
}
</script>
</head>

<body>
<form name="frm">
 <input type="text" name="name"  onKeyUp="init();">
 </form>
  <div id="Layer1" style="position:absolute; left:10px; top:54px; width:147px; height:14px; z-index:1; background-color: #FFFFFF; layer-background-color: #FFFFFF; border: blue 1px solid; ">
  <table id="wordsListTable" >
		<tbody id="wordsListTbody"></tbody>
	</table>
  </div>
 
</body>
</html>
