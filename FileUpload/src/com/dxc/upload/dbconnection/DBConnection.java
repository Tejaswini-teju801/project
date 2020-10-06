package com.dxc.upload.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	Connection c=null;


	//This method makes the connection to database 'amspro' and returns connection object
	public Connection makeConnection()
	{
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("Driver Loadded Succefully");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/upload","root","12345");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	return c;


	}
		
		
	public boolean checkConnection(Connection c)
	{
		Boolean b=false;
		if(c==null)
		{
			b=false;
			System.out.println("connection failed");
			
		}
		else if(c!=null)
		{
			b=true;
			System.out.println("Succesfully Connected to Database 'upload'");
			
		}
		
		return b;
	}

		
}
