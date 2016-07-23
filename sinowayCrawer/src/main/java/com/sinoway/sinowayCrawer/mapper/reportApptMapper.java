package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.reportAppt;

public interface reportApptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(reportAppt record);

    int insertSelective(reportAppt record);

    reportAppt selectByPrimaryKey(Integer id);
    List<reportAppt> selectallbyqueried_number(String queried_number);
    List<reportAppt> selectallbyReportId(String reportId);
	int selectByReportID(String reportID);

    int updateByPrimaryKeySelective(reportAppt record);

    int updateByPrimaryKey(reportAppt record);
}