package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.loanOverdueAccount;

public interface loanOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(loanOverdueAccount record);

    int insertSelective(loanOverdueAccount record);

    loanOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(loanOverdueAccount record);

    int updateByPrimaryKey(loanOverdueAccount record);
}