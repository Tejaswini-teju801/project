package com.dxc.upload.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import com.dxc.upload.entity.User;

public interface UserFunctions {

	public String register(User u);
	public String login(String user,String pwd);
	public boolean uploadFile(String loginid,Part p,String filepath,String dbpath)throws IOException;
	 public ArrayList<String> listAllFiles(String filepath);
}
