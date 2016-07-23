package com.sinoway.sinowayCrawer.mapper;

import com.sinoway.sinowayCrawer.entitys.LoanloanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.loanOverdueAccount;

public interface LoanloanOverdueAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanloanOverdueAccount record);

    int insertSelective(LoanloanOverdueAccount record);

    LoanloanOverdueAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanloanOverdueAccount record);

    int updateByPrimaryKey(LoanloanOverdueAccount record);
}