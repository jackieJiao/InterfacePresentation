package com.sinoway.sinowayCrawer.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sinoway.sinowayCrawer.entitys.InfoOrderStatusSummary;
import com.sinoway.sinowayCrawer.entitys.SCondition;
import com.sinoway.sinowayCrawer.entitys.Time3;
import com.sinoway.sinowayCrawer.entitys.ToShow;
import com.sinoway.sinowayCrawer.entitys.ToShowSummary;
import com.sinoway.sinowayCrawer.service.OrderStatusService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/*
 * toshow page
 * generate data
 */
@Controller
@RequestMapping("/test")
public class Orderstatustest {
	@Autowired
	private OrderStatusService os;

	//search by condition
	@RequestMapping(value = "/searchBy")
	@ResponseBody
	public Map<String, Object> searchBy(SCondition data) {
		// variables which is to save into toShowSummary;
		/*
		 * String order_code=null; String name=null; String cardid=null; String
		 * phoneNumber=null; String clicktime=null; String sinoSign=null; String
		 * centerSign=null;//系统登陆：包括两种状态 String answerYN=null; String
		 * getCode=null; String isDone=null;
		 */
//		String data=req.getParameter("data");
//		JsonConfig jsonConfig = new JsonConfig();
		//userInfo即是前台传过来的json串名称
//		JSONObject json1 = JSONObject.fromObject(data,jsonConfig);
		//json1即是转换后的json对象了，
//		 String name11=json1.getString("timeItem");//前台穿过来的json串中的name
	
		List<InfoOrderStatusSummary> listsc = os.getAllBySCondition(data);
		// toshowlist
		List<ToShowSummary> listSummary = new ArrayList<>();
		for (InfoOrderStatusSummary ios : listsc) {
			ToShowSummary toshowsmry = new ToShowSummary();
			
			// set value of toshowsmry

			String order_code = (ios.getOrder_code() == null||ios.getOrder_code().equals("-")) ? "-" : ios.getOrder_code();
			String name = (ios.getName() == null ||ios.getName().equals("-"))? "-" : ios.getName();
			String cardid = (ios.getCardid() == null||ios.getCardid().equals("-")) ? "-" : GS(ios.getCardid());
			String phoneNumber = (ios.getPhoneNumber() == null||ios.getPhoneNumber().equals("-")) ? "-" : PS(ios.getPhoneNumber());
			String clicktime = null == ios.getClicktime() ? "-" : ios.getClicktime();
			String sinoSign = null == ios.getSinoSign() ? "-" : ios.getSinoSign();
			// String
			// centerSign=null==ios.getCenterSign()?(null==ios.getCenterNoSucc()?"-":("**"+ios.getCenterNoSucc())):ios.getCenterSign();//系统登陆：包括两种状态
			String centerSign = null == ios.getCenterSign() ? "-" : ios.getCenterSign(); // 系统登陆：包括两种状态
			String answerYN = null == ios.getAnswerSucc() ? "-" : ios.getAnswerSucc();
			String getCode = null == ios.getGetCode() ? "-" : ios.getGetCode();
			String isDone=null;
			if(null==ios.getIsDone()){
				isDone ="未完成";
			}
			else{
				 isDone=ios.getIsDone().equals("1")? "完成" : "未完成";
			}
//			String isDone =null==ios.getIsDone()?"未完成":(ios.getIsDone().equals("1")? "完成" : "未完成");

			toshowsmry.setOrder_code(order_code);
			toshowsmry.setName(name);
			toshowsmry.setCardid(cardid);
			toshowsmry.setPhoneNumber(phoneNumber);
			toshowsmry.setClicktime(clicktime);
			toshowsmry.setSinoSign(sinoSign);
			toshowsmry.setCenterSign(centerSign);
			toshowsmry.setAnswerYN(answerYN);
			toshowsmry.setGetCode(getCode);
			toshowsmry.setIsDone(isDone);
			listSummary.add(toshowsmry);
		}
		Map<String, Object> map2 = new HashMap<>();
		map2.put("result", listSummary);
		return map2;
	}
	
	
	@RequestMapping(value = "/getAllsmry")
	@ResponseBody
	public Map<String, Object> getAllsmry() {
		// variables which is to save into toShowSummary;
		/*
		 * String order_code=null; String name=null; String cardid=null; String
		 * phoneNumber=null; String clicktime=null; String sinoSign=null; String
		 * centerSign=null;//系统登陆：包括两种状态 String answerYN=null; String
		 * getCode=null; String isDone=null;
		 */

		List<InfoOrderStatusSummary> listgas = os.getAllSummary();
		// toshowlist
		List<ToShowSummary> listSummary = new ArrayList<>();
		for (InfoOrderStatusSummary ios : listgas) {
			ToShowSummary toshowsmry = new ToShowSummary();
			// set value of toshowsmry

			String order_code = (ios.getOrder_code() == null||ios.getOrder_code().equals("-") ) ? "-" : ios.getOrder_code();
			String name = (ios.getName() == null ||ios.getName().equals("-"))? "-" : ios.getName();
			String cardid = (ios.getCardid() == null||ios.getCardid().equals("-")) ? "-" : GS(ios.getCardid());
			String phoneNumber = (ios.getPhoneNumber() == null||ios.getPhoneNumber().equals("-")) ? "-" : PS(ios.getPhoneNumber());
			String clicktime = null == ios.getClicktime() ? "-" : ios.getClicktime();
			String sinoSign = null == ios.getSinoSign() ? "-" : ios.getSinoSign();
			String centerSign = null == ios.getCenterSign() ? "-" : ios.getCenterSign(); // 系统登陆：包括两种状态
			String answerYN = null == ios.getAnswerSucc() ? "-" : ios.getAnswerSucc();
			String getCode = null == ios.getGetCode() ? "-" : ios.getGetCode();
			String isDone=null;
			if(null==ios.getIsDone()){
				isDone ="未完成";
			}
			else{
				 isDone=ios.getIsDone().equals("1")? "完成" : "未完成";
			}
			toshowsmry.setOrder_code(order_code);
			toshowsmry.setName(name);
			toshowsmry.setCardid(cardid);
			toshowsmry.setPhoneNumber(phoneNumber);
			toshowsmry.setClicktime(clicktime);
			toshowsmry.setSinoSign(sinoSign);
			toshowsmry.setCenterSign(centerSign);
			toshowsmry.setAnswerYN(answerYN);
			toshowsmry.setGetCode(getCode);
			toshowsmry.setIsDone(isDone);
			listSummary.add(toshowsmry);
		}
		Map<String, Object> map2 = new HashMap<>();
		map2.put("result", listSummary);
		return map2;
	}

	// mask phoneNumber
	private String PS(String phoneNumber) {
		// TODO Auto-generated method stub
		StringBuilder v1 = new StringBuilder(phoneNumber);
		v1.replace(3, 8, "*****");
		return v1.toString();
	}

	// mask cardid
	private String GS(String cardid) {
		// TODO Auto-generated method stub
		StringBuilder v1 = new StringBuilder(cardid);
		v1.replace(3, 14, "***********");
		return v1.toString();
	}

	@RequestMapping(value = "/test1")
	@ResponseBody
	public Map<String, Object> test() {
		// 1.get all orderCode;
		List<String> list1 = os.getAllOrdercode();
		// List<String> list2=os.getStatustypeByOrdercode("333333");
		String date1 = os.getDateByOrdercodeAndType("333333", "create_order");
		// listalldate是展示目标的时间表格。需要最终展示。
		List<ToShow> listAllDate = new ArrayList<>();
		// foreach list1
		for (String oc : list1) {
			// to new ToShow instance for each OrderCode
			ToShow toshow = new ToShow("暂无", "暂无", "暂无", "暂无", "暂无", "暂无", "暂无");
			toshow.setOrdercode(oc);

			// get ListOf statusType according oc
			List<String> listType = os.getStatustypeByOrdercode(oc);
			if (listType.contains("CREATE_ORDER")) {
				toshow.setCreatetime(os.getDateByOrdercodeAndType(oc, "create_order"));
			}
			/*
			 * if(listType.contains("REGISTER_HD_USER")){
			 * toshow.set(os.getDateByOrdercodeAndType(oc, "REGISTER_HD_USER"));
			 * }
			 */
			if (listType.contains("USER_CENTER_SIGN")) {
				toshow.setRegisterfinishtime(os.getDateByOrdercodeAndType(oc, "USER_CENTER_SIGN"));
			}
			if (listType.contains("CREATE_REPORT")) {
				toshow.setApplytime(os.getDateByOrdercodeAndType(oc, "CREATE_REPORT"));
			}
			if (listType.contains("COMMIT_CODE")) {
				toshow.setGetreporttime(os.getDateByOrdercodeAndType(oc, "COMMIT_CODE"));
				String useraccount = os.getUseraccountByOrdercodeAndType(oc, "COMMIT_CODE");
				String oname = os.getNameByUseraccount(useraccount);// from
																	// center;
				String ocardid = os.getCardidByUseraccount(useraccount);
				toshow.setOname(oname);
				toshow.setOcardid(ocardid);
			}
			if (listType.contains("CREATE_REPORT_ERR_END")) {
				toshow.setFinishtime(os.getDateByOrdercodeAndType(oc, "CREATE_REPORT_ERR_END"));
			}

			// finish showInstance, add to showList
			listAllDate.add(toshow);
		}
		Map<String, Object> map1 = new HashMap<>();
		map1.put("result", listAllDate);
		return map1;

		// System.out.println(list1.get(0));
	}

	/*
	 * // public static void main(String[] args) { // String a="aaa"; // String
	 * b="bbb"; // List<String> list4=new ArrayList<>(); // list4.add(a); //
	 * list4.add(b); // list4.add("ccc"); //
	 * System.out.println(list4.contains(a)); // }
	 */
	@RequestMapping(value = "/getExcel", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
	public void getExcel(@RequestParam(value = "data") String data, HttpServletResponse response) throws IOException {
		
		 response.setContentType("text/plain;charset='utf-8'");
		OutputStream out=null;
		System.out.println("THis is in getExcel");
		System.out.println(data);
//		FileOutputStream fout = new FileOutputStream("E:/students.xls");
		List<ToShowSummary> list = JSON.parseArray(data, ToShowSummary.class);

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("订单状态");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("订单号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("身份证号");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("手机号");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("访问时间");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("平台登录");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("系统登录");
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue("申请完成时间");
		cell.setCellStyle(style);
		cell = row.createCell(8);
		cell.setCellValue("生成报告时间");
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue("流程完成时间");
		cell.setCellStyle(style);


		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			ToShowSummary tss = (ToShowSummary) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(tss.getOrder_code());
			row.createCell(1).setCellValue(tss.getName());
			row.createCell(2).setCellValue(tss.getCardid());
			row.createCell(3).setCellValue(tss.getPhoneNumber());
			row.createCell(4).setCellValue(tss.getClicktime());
			row.createCell(5).setCellValue(tss.getSinoSign());
			row.createCell(6).setCellValue(tss.getCenterSign());
			row.createCell(7).setCellValue(tss.getAnswerYN());
			row.createCell(8).setCellValue(tss.getGetCode());
			row.createCell(9).setCellValue(tss.getIsDone());
		}
		
		// 第六步，将文件存到指定位置
		try {
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=orderstates.xls");
		    out=response.getOutputStream();
//			wb.write(fout);
			wb.write(out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
//			fout.close();
		}

	}
	
	@RequestMapping(value = "/getExcel1", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
	public void getExcel1(@RequestParam(value = "data") String data, HttpServletResponse response) throws IOException {
		
		 response.setContentType("text/plain;charset='utf-8'");
		OutputStream out=null;
		System.out.println("THis is in getExcel");
		System.out.println(data);
//		FileOutputStream fout = new FileOutputStream("E:/students.xls");
		List<Time3> list = JSON.parseArray(data, Time3.class);

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("订单状态");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("手机号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("身份证号");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("平台登录时间");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("更新时间");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("生成报告时间");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("请求时间");
		cell.setCellStyle(style);
		


		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Time3 tss = (Time3) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(tss.getPhone());
			row.createCell(1).setCellValue(tss.getName());
			row.createCell(2).setCellValue(tss.getCardid());
			row.createCell(3).setCellValue(tss.getLoginTime());
			row.createCell(4).setCellValue(tss.getUpdateTime());
			row.createCell(5).setCellValue(tss.getReportTime());
			row.createCell(6).setCellValue(tss.getRequestTime());
			
		}
		
		// 第六步，将文件存到指定位置
		try {
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=orderstates.xls");
		    out=response.getOutputStream();
//			wb.write(fout);
			wb.write(out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
//			fout.close();
		}

	}
	
	@RequestMapping(value = "/get3timetable")
	@ResponseBody
	public Map<String, Object> get3timetable( HttpServletResponse response) throws IOException {
		
		List<Time3> list3= new ArrayList<>();
		list3=os.get3timetable();
		System.out.println(list3.size());
		Map<String, Object> map1 = new HashMap<>();
		map1.put("result", list3);
		return map1;
	
	}
	@RequestMapping(value ="/getnumbers", method = RequestMethod.POST)
	public void getnumbers(HttpServletRequest req,HttpServletResponse resp){
		os.getFinishNumber();
		os.getFinishReg();
		
	}

}
