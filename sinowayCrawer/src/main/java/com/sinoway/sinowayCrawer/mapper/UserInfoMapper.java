package com.sinoway.sinowayCrawer.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sinoway.sinowayCrawer.entitys.UserInfo;




@Component("userInfoMapper")
public interface UserInfoMapper {
  

	List<UserInfo> selectUserByCondition(Map<String, Object> pramMap);
	
	
}