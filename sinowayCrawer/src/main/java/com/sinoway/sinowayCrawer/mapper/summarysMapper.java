package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.summarys;

public interface summarysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(summarys record);

    int insertSelective(summarys record);

    summarys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(summarys record);

    int updateByPrimaryKey(summarys record);
}