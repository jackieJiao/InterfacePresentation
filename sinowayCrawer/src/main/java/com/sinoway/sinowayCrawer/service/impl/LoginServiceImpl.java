package com.sinoway.sinowayCrawer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.sinowayCrawer.entitys.UserInfo;
import com.sinoway.sinowayCrawer.mapper.UserInfoMapper;
import com.sinoway.sinowayCrawer.service.LoginService;
import com.sinoway.sinowayCrawer.utils.MD5;





@Service("enterService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	 
	public UserInfo selectUserForLogin(String userName, String userPsw) {

		UserInfo user = null;
		Map<String, Object> pramMap = new HashMap<String, Object>();
		pramMap.put("userName", userName);

		List<UserInfo> users = userInfoMapper.selectUserByCondition(pramMap);

		// 用户唯一，当用户存在且唯一时才能登陆成功。
		if (!users.isEmpty() && users.size() == 1) {
			user = users.get(0);
			// 验证用户密码是否正确
			if (!user.getPassword().equals(MD5.getMD5Str(userPsw))) {
			//if (!user.getUserPsw().equals(userPsw)) {
				user = null;
			}
		}

		return user;
	}
}
