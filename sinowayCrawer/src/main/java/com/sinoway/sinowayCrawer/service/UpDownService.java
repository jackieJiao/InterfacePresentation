package com.sinoway.sinowayCrawer.service;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
@Service
public interface UpDownService {
	/*
	 * 上传下载文件
	 * 参数说明
	 * upload(request,上传的此路径)
	 * download(response,需要下载的文件名字)
	 */
	
	public void upload(HttpServletRequest req,String filePath) throws FileUploadException, IOException;
	
	
	public void download(HttpServletResponse res, String fileName);
}
