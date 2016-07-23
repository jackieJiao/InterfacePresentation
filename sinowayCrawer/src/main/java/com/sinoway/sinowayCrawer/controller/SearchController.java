package com.sinoway.sinowayCrawer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.CreditOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.reportAppt;
import com.sinoway.sinowayCrawer.service.ApptService;
import com.sinoway.sinowayCrawer.service.UpDownService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

@Controller

public class SearchController {
	/*
	 * 得到cardid，查出报告list，展示到result.jsp
	 */
	@Autowired
	private ApptService apptservice;
	@Autowired
	private UpDownService ud;
	
	
//	@RequestMapping(value="/Excel.action")
//	public void excel(HttpServletResponse res){
//		ud.download(res, "/jiacu.xml");
//	}
	
	@RequestMapping(value="/search.action")
	@ResponseBody
	public Map<String, Object> search(HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException{
		String cardId=req.getParameter("cardid");
		System.out.println("search.action");
		System.out.println(req.getParameter("cardid"));
		//查询report-appt,返回list结果集合；
		List<reportAppt> list=apptservice.getList(cardId);
		System.out.println(list.size());
//		System.out.println(list.get(0).getRequestTime());
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/result.jsp").forward(req, response);
		System.out.println(req.getServletContext().getRealPath("/"));
		Map<String, Object> map1= new HashMap<>();
		map1.put("result", list);
		System.out.println(map1.toString());
		
//		System.out.println(list.get(0).getRequestTime());
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(req, response);
		//System.out.println(req.getServletContext().getRealPath("/"));
		return map1;
	
	}
	
	//得到模板需要的数据
	@RequestMapping(value="/getdata.action")
	public void getdata(HttpServletRequest req,HttpServletResponse response){
		System.out.println("getdata.action------");
		System.out.println("得到reportID"+req.getParameter("rid"));
		//得到reportID
		String reportId=req.getParameter("rid");
		List<reportAppt> list=apptservice.selectallbyReportId(reportId);
//		System.out.println("wotddddded" + idnumber);
		System.out.println("已经找到此行数据，名字为：" + list.get(0).getQueriedName());
		String name=list.get(0).getQueriedName();
		String time1=list.get(0).getRequestTime();
		String idnumber=list.get(0).getQueriedNumber();
		
		List<HousingNoOverdueAccountDetail> listHN=apptservice.gethousingNo(reportId);
		List<HousingOverdueAccountDetail>  listH  =apptservice.gethousing(reportId);
		List<LoanOverdueAccountDetail> 	   listL  =apptservice.getloan(reportId);
		List<LoanNoOverdueAccountDetail>   listLN =apptservice.getloanNo(reportId);
		List<CreditNoOverdueAccountDetail> listCN =apptservice.getcreditNo(reportId);
		List<CreditOverdueAccountDetail>   listC  =apptservice.getcredit(reportId);
		List<personalQueryDetails> listP          =apptservice.getpersonQ(reportId);
		List<institutionQueryDetails> listI       =apptservice.getinstituteQ(reportId);
//		System.out.println(listHN.get(0).getDetail());
		//generate datamap
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("reportId", reportId);
		dataMap.put("name", name);
		System.out.println("name = " + name);
		dataMap.put("idnumber", idnumber);
		dataMap.put("time1", time1);
		
		dataMap.put("userList1",listHN);
		dataMap.put("userList2",listH);
		dataMap.put("userList3",listL);
		dataMap.put("userList4",listLN);
		dataMap.put("userList5",listCN);
		dataMap.put("userList6",listC);
		dataMap.put("userList7",listP);
		dataMap.put("userList8",listI);
		//调processT

		ProcessT2 p= new ProcessT2();
		try {
			p.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.process(dataMap,req);
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ud.download(response, "/demo1.xml");
	}
	
	
	
}
