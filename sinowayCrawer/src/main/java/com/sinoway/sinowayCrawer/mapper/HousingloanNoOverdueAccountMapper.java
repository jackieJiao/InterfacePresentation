package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.HousingloanNoOverdueAccount;

public interface HousingloanNoOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HousingloanNoOverdueAccount record);

    int insertSelective(HousingloanNoOverdueAccount record);

    HousingloanNoOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HousingloanNoOverdueAccount record);

    int updateByPrimaryKey(HousingloanNoOverdueAccount record);
}