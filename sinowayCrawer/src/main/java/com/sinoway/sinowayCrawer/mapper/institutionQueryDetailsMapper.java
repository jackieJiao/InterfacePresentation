package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;

public interface institutionQueryDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(institutionQueryDetails record);

    int insertSelective(institutionQueryDetails record);

    institutionQueryDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(institutionQueryDetails record);

    int updateByPrimaryKey(institutionQueryDetails record);


	List<institutionQueryDetails> selectallbyreportid(String reportid);
}