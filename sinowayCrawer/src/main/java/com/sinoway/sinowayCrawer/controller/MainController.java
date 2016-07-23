package com.sinoway.sinowayCrawer.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	protected static Logger logger=Logger.getLogger("controller");
	
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage(){
		logger.debug("Received request to show common page");
		return "main";  
	}
	 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String getAadminPage() {  
        logger.debug("Received request to show admin page");  
        return "admin";   
    } 
    @RequestMapping(value = "/states", method = RequestMethod.GET)  
    public String getUploadPage() {  
        logger.debug("Received request to show upload page");  
        return "states";   
    }
    @RequestMapping(value = "/download", method = RequestMethod.GET)  
    public String getCheckPage() {  
        logger.debug("Received request to show check page");  
        return "download";   
    }
    @RequestMapping(value = "/states2", method = RequestMethod.GET)  
    public String getCheck1Page() {  
        logger.debug("Received request to show check page");  
        return "states2";   
    }
}
