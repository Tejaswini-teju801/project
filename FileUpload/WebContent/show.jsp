<%@page import="java.io.*" %>
<html>
<!-- <body background="C:\images\background.png"> -->
<font color="blue">****************Displaying the contents of file****************</font><br>
</html>
 <%
String fname=request.getParameter("value");
File f=new File(fname);
if(f.exists())
{
out.println("<br><font color=green>The contents of file:</font> "+f+"<font color=green> are:</font><br><br>");
FileInputStream fl=new FileInputStream(f);
int x;
while((x=fl.read())!= -1)
{
	out.println((char)x);

}
fl.close();
}
else
	out.println("file not exists");
 
 /* String line = null;
 FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
               out.println(line);
            }
            bufferedReader.close(); */
            %>