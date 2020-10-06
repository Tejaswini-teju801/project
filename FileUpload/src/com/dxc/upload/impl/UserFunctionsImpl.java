package com.dxc.upload.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import com.dxc.upload.dbconnection.DBConnection;
import com.dxc.upload.entity.User;

public class UserFunctionsImpl implements UserFunctions {
DBConnection db=new DBConnection();
Connection c=db.makeConnection();
	@Override
	public String register(User u) {
		// TODO Auto-generated method stub
		if(db.checkConnection(c))
		{
			try
			{
				PreparedStatement ps=c.prepareStatement("insert into users values(?,?,?,?,?,?)");
				
				ps.setString(1,u.getName());
				ps.setString(2,u.getLoginid());
				ps.setString(3,u.getPwd());
				ps.setString(4,u.getEmail());
				ps.setString(5,u.getAddress());
				ps.setString(6, u.getPhno());
				ps.executeUpdate();
				System.out.println("Registration sucessfull!!!!");
				//ps.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
				
			}
		}
		
		
		
		return u.getName();
	}

	@Override
	public String login(String user, String pwds) {
		// TODO Auto-generated method stub
		String status = null;
		if(db.checkConnection(c))
		{
			
			try
			{
				PreparedStatement ps=c.prepareStatement("select loginid,pwd,name from users");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
				if(user.equals(rs.getString("loginid")))
					
				{
					//System.out.println("inside login"+rs.getString("loginid"));
	                 if(rs.getNString("pwd").equals(pwds))
	                	 
	                 {
	                	// System.out.println("inside pwd"+pwds);
	                	 status=rs.getString("name");
	                	 //System.out.println(status);
	                	 break;
	                 }
	                 else
	                	 status="incorrect password";
		
				}
				
				else status="incorrect username";
				}
		
				//rs.close();
				//ps.close();
		
		
		
	}catch(SQLException e)
			{
		e.printStackTrace();
		
	}
			
}
return status;
	}

	@Override
	public boolean uploadFile(String lid,Part filePart,String filepath,String dbpath) throws IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		System.out.println(lid);
		 InputStream inputStream = null;
		 Upload up=new Upload();
		String  fileName = up.extractFileName(filePart);
		System.out.println(fileName);
		fileName = new File(fileName).getName();
        System.out.println(fileName);
       System.out.println(filepath);
		if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		filePart.write(filepath + File.separator + fileName);
	       System.out.println(filepath + File.separator + fileName);
	       System.out.println("written");
		try
		{
        PreparedStatement ps = c.prepareStatement("insert into fileinfo values(?,?,?)");
        ps.setString(1,lid);
         
        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            ps.setBlob(2, inputStream);
        }
        //File.separator+dbpath + File.separator +
        ps.setString(3, fileName );
        // sends the statement to the database server
        int row = ps.executeUpdate();
       if(row>0)
    	   flag= true;
       
       
      
       
       
       
		//ps.close();
       
		}catch(SQLException e)
		{
	e.printStackTrace();
	return false;
		
		}
		return flag;
		
		
	}
	
	
	
	
	 public ArrayList<String> listAllFiles(String loginid)
	 {
		
		
				/*
				 * String appPath = request.getServletContext().getRealPath("");
				 * System.out.println(appPath); String savePath = appPath + File.separator +
				 * SAVE_DIR; System.out.println(savePath);
				 */
		 ArrayList<String> filelist=new ArrayList();
		 try {
		 PreparedStatement ps1 = c.prepareStatement("select filepath from fileinfo where loginid=(?)");
	      ps1.setString(1,loginid);
		 ResultSet rs= ps1.executeQuery();
	      while(rs.next())
			{
			//System.out.println("path name:"+rs.getString(1));
	    	  filelist.add(rs.getString(1));
			}
	      //rs.close();
			//ps1.close();
		 }catch(Exception e)
		 {e.printStackTrace();
		 }
		 
		 return filelist;
	 }
	

	}