package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.query;

public interface queryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(query record);

    int insertSelective(query record);

    query selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(query record);

    int updateByPrimaryKey(query record);
}