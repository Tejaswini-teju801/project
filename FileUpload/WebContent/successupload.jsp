<html>
<body background="C:\images\background.png">
<center>
<h3><font color="#701C1C">Your file is uploaded successfully!!</font></h3>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2><font color="#F5F5DC">The files in the directory are.........</font></h2>
<c:forEach items="${list}" var="file">
<!-- <form action="show.jsp" method="get">
<input type="hidden" name="myfiles" value="http://localhost:8989/FileUpload/show.jsp"> -->
<table border="1"><tr><td>
         <a href="http://localhost:8989/FileUpload/show.jsp?value=${file}"><font color="#701C1C">${file}&ensp;</font></a></td>
       <td><a href="http://localhost:8989/FileUpload/download.jsp?dvalue=${file}"><font color="#03C03C">download</font></a>
       </td></tr>
        </table> 
        <!--  </form> -->
    </c:forEach>
    <p><font color="#FBCEB1">Click the file to view it and download link to download it</font></p>
</center>
</html>
