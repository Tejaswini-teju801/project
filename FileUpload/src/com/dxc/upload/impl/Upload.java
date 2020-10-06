package com.dxc.upload.impl;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.Part;

public class Upload {
	 public String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        //content-disposition is header indicating if the content is expected to be displayed in the browser, 
	        String[] items = contentDisp.split(";");
	        //multi-part; name="fieldName"; filename="filename.jpg"
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }
	 
	 public ArrayList<String> listAllFiles(String filepath)
	 {
		
				/*
				 * String appPath = request.getServletContext().getRealPath("");
				 * System.out.println(appPath); String savePath = appPath + File.separator +
				 * SAVE_DIR; System.out.println(savePath);
				 */
		 ArrayList<String> filelist=new ArrayList();
				String files[] = new File(filepath).list();
				for(String path:files) {
					filelist.add(path);
					
				}
		 return filelist;
	 }
	 
	 public String fileUpload(Collection<Part>cp,String filepath) throws IOException
	 {
		 File fileSaveDir = new File(filepath);
		 if (!fileSaveDir.exists()) {
			  fileSaveDir.mkdir(); 
			  }
		 String fileName="";
	     
         for (Part part : cp) {
             fileName = extractFileName(part);
        	 
             // refines the fileName in case it is an absolute path
             fileName = new File(fileName).getName();
             System.out.println(fileName);
            part.write(filepath + File.separator + fileName);
            System.out.println("written");
            
            
         }
         return fileName;
	 }
	 
	 
	 
	 
}
