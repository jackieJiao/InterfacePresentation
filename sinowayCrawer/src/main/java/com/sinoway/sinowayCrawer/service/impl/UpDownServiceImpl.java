package com.sinoway.sinowayCrawer.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.sinoway.sinowayCrawer.service.UpDownService;



@Service
public class UpDownServiceImpl implements UpDownService {

	 
	public void upload(HttpServletRequest req,String filePath) throws FileUploadException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1000 * 1024);
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		List<FileItem> items = sfu.parseRequest(req);
		for (int i = 0; i < items.size(); i++) {
			byte[] bs = new byte[items.get(i).getInputStream().available()];
			items.get(i).getInputStream().read(bs);
			// get fileName 
			String fileName = items.get(i).getName();
			if(isFullName(fileName)){
				fileName=getShortName(fileName);
			}
			System.out.println(fileName + "    this is fileName");
			FileOutputStream fos = new FileOutputStream(filePath + fileName);
			fos.write(bs);
			fos.close();
		}
	}

	 
	public void download(HttpServletResponse res , String fileName) {
		try {
			
			URL url = getClass().getResource(fileName);
			System.out.println(url);
			File f = new File(url.toURI());
			System.out.println("Loading file " + fileName + "(" + f.getAbsolutePath() + ")");
			if (f.exists()) {
				res.setContentType("application/xls");
				res.setContentLength(new Long(f.length()).intValue());
				res.setHeader("Content-Disposition", "attachment; filename=report.doc");
				FileCopyUtils.copy(new FileInputStream(f), res.getOutputStream());
			} else {
				System.out.println("File" + fileName + "(" + f.getAbsolutePath() + ") does not exist");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	
	//先判断文件名是不是路径+文件名，如果是，把路径去掉。
	private boolean isFullName(String fileName){
		if(fileName.indexOf(":\\")>-1){
			return true;
		}else return false;
	}
	
	private String getShortName(String fullName){
		String shortName= fullName.substring(fullName.lastIndexOf("\\")+1, fullName.length());
		System.out.println(fullName.substring(fullName.lastIndexOf("\\")+1, fullName.length()));
		return shortName;
	}
}
