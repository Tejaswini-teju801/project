<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body background="C:\images\background.png">
<h2><font color="#9400D3">The files in the directory are.........</font></h2>
<table border="3">
<c:forEach items="${listfiles}" var="file">
<!-- <form action="show.jsp" method="get">
<input type="hidden" name="myfiles" value="http://localhost:8989/FileUpload/show.jsp"> -->

       <tr> <td> <a href="http://localhost:8989/FileUpload/show.jsp?value=${file}">${file}      </a></td></tr>
        <tr> <td> <a href="http://localhost:8989/FileUpload/download.jsp?dvalue=${file}"><font color="green">download</font> <br></a>
          </td></tr>
        
        <!--  </form> -->
    </c:forEach>
      </table>
    <p><q><font color="red">Click the file to view it and download link to download it</font></q></p>
    </html>
    
  