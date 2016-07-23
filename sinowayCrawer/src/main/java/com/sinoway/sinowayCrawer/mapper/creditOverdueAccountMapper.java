package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.creditOverdueAccount;

public interface creditOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(creditOverdueAccount record);

    int insertSelective(creditOverdueAccount record);

    creditOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(creditOverdueAccount record);

    int updateByPrimaryKey(creditOverdueAccount record);
}