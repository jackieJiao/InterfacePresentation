package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.loanNoOverdueAccount;

public interface loanNoOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(loanNoOverdueAccount record);

    int insertSelective(loanNoOverdueAccount record);

    loanNoOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(loanNoOverdueAccount record);

    int updateByPrimaryKey(loanNoOverdueAccount record);
}