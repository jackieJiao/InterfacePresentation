package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.creditRecord;

public interface creditRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(creditRecord record);

    int insertSelective(creditRecord record);

    creditRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(creditRecord record);

    int updateByPrimaryKey(creditRecord record);
}