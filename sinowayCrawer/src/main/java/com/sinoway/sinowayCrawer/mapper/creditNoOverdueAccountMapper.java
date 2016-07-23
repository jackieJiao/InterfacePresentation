package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.creditNoOverdueAccount;

public interface creditNoOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(creditNoOverdueAccount record);

    int insertSelective(creditNoOverdueAccount record);

    creditNoOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(creditNoOverdueAccount record);

    int updateByPrimaryKey(creditNoOverdueAccount record);
}