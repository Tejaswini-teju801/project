<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "http://localhost:8989/FileUpload/upload" method = "post" enctype = "multipart/form-data">
      <%--    <input type="hidden" name="name" value="${name}"> --%>
         <input type = "file" name = "file" />
         <br><br>
         <input type = "submit" value = "Upload File" />
      </form>
   </body>
   
</html>