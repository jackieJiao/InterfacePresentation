package com.sinoway.sinowayCrawer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.sinowayCrawer.entitys.InfoOrderStatusSummary;
import com.sinoway.sinowayCrawer.entitys.SCondition;
import com.sinoway.sinowayCrawer.entitys.Time3;
import com.sinoway.sinowayCrawer.mapper.InfoOrderStatusMapper;
import com.sinoway.sinowayCrawer.mapper.InfoOrderStatusSummaryMapper;
import com.sinoway.sinowayCrawer.service.OrderStatusService;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private InfoOrderStatusMapper os;
	@Autowired
	private InfoOrderStatusSummaryMapper osm;
	@Override
	public List<String> getAllOrdercode() {
		List<String> list1=os.selectAllOrdercode();
		return list1;
	}

	@Override
	public List<String> getStatustypeByOrdercode(String ordercode) {
		List<String> list2=os.getStatustypeByOrdercode(ordercode);
		return list2;
	}

	@Override
	public String getDateByOrdercodeAndType(String ordercode, String type) {
		String date1=os.getDateByOrdercodeAndType(ordercode, type);
		return date1;
	}

	@Override
	public String getUseraccountByOrdercodeAndType(String ordercode, String type) {
		// TODO Auto-generated method stub
		//same as getdate
		String useraccount=os.getUseraccountByOrdercodeAndType(ordercode, type);
		return useraccount;
	}

	@Override
	public String getNameByUseraccount(String useraccount) {
		// TODO Auto-generated method stub
		String oname=os.getNameByUseraccount(useraccount);
		return oname;
	}

	@Override
	public String getCardidByUseraccount(String useraccount) {
		// TODO Auto-generated method stub
		String ocardid=os.getCardidByUseraccount(useraccount);
		return ocardid;
	}

	@Override
	public List<InfoOrderStatusSummary> getAllSummary() {
		// TODO Auto-generated method stub
		List<InfoOrderStatusSummary> listS= osm.getAll();
		return listS;
	}

	@Override
	public List<InfoOrderStatusSummary> getAllBySCondition(SCondition scondition) {
		// TODO Auto-generated method stub
		List<InfoOrderStatusSummary> listSc= osm.getAllBySCondition(scondition);
		return listSc;
	}

	@Override
	public List<Time3> get3timetable() {
		// TODO Auto-generated method stub
		List<Time3> list3=osm.getTime3();
		return list3;
	}

	@Override
	public String getFinishNumber() {
		// TODO Auto-generated method stub
		return osm.getFinishNuber();
	}

	@Override
	public String getFinishReg() {
		// TODO Auto-generated method stub
		return osm.getFinishReg();
	}

}
