<%@ page  contentType="text/html;charset=GB2312" %>

<html>
   <head>
       <title>Non-cache.jsp</title>
   </head>
   <body>
       <h2>��������cache������ </h2>
	   <%  
	       if(request.getProtocol().compareTo("HTTP/1.0")==0){
			    response.setHeader("Pragma","no-cache");
		   }else if(request.getProtocol().compareTo("HTTP/1.1")==0){
			    response.setHeader("Cache-Control","no-cache");
		   }
           //����������cache�б������Ч��Ϊ0��
		   response.setDateHeader("Expires",0);
	   %>
   </body>
</html>