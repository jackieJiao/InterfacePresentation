package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;

public interface personalQueryDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(personalQueryDetails record);

    int insertSelective(personalQueryDetails record);

    personalQueryDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(personalQueryDetails record);

    int updateByPrimaryKey(personalQueryDetails record);

	List<personalQueryDetails> selectallbyreportid(String reportid);
}