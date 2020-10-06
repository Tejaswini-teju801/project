<%@page import="java.io.*" %>

 <%
 String fname=request.getParameter("dvalue");
// out.println(fname);
 File f=new File(fname);
 if(f.exists())
 {

 FileInputStream fl=new FileInputStream(f);
 response.setContentType("APPLICATION/OCTET-STREAM");
	response.setHeader("Content-Disposition", "attachment; filename=\""
			+ f + "\"");
int x;
while((x=fl.read())!= -1)
{
	out.write(x);

}
fl.close();
 }else
	 out.println("file not exists");
	 %>