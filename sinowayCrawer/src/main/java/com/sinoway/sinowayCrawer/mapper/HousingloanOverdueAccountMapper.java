package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.HousingloanOverdueAccount;

public interface HousingloanOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HousingloanOverdueAccount record);

    int insertSelective(HousingloanOverdueAccount record);

    HousingloanOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HousingloanOverdueAccount record);

    int updateByPrimaryKey(HousingloanOverdueAccount record);
}