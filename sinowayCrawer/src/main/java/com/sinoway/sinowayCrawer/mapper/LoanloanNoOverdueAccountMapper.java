package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.LoanloanNoOverdueAccount;

public interface LoanloanNoOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanloanNoOverdueAccount record);

    int insertSelective(LoanloanNoOverdueAccount record);

    LoanloanNoOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanloanNoOverdueAccount record);

    int updateByPrimaryKey(LoanloanNoOverdueAccount record);
}