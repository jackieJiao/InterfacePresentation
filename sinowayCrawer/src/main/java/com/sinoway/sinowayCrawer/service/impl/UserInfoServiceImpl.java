package com.sinoway.sinowayCrawer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.sinowayCrawer.entitys.UserInfo;
import com.sinoway.sinowayCrawer.mapper.UserInfoMapper;
import com.sinoway.sinowayCrawer.service.UserInfoService;
import com.sinoway.sinowayCrawer.utils.MD5;




@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 根据查询条件查询用户信息
	 * @param pramMap 查询条件
	 * @param pageNum 当前页，为null时表示查询全部数据
	 * @param pageSize 分页大小
	 * @return 返回用户列表
	 */
	 
	public List<UserInfo> selectUserByCondition(Map<String, Object> pramMap,Integer pageNum, Integer pageSize) {
		if(pramMap == null){
			pramMap = new HashMap<String, Object>();
		}
		if(pageNum != null && pageSize != null){
			pramMap.put("pageNum", pageNum * pageSize);
			pramMap.put("pageSize", pageSize);
		}
		return userInfoMapper.selectUserByCondition(pramMap);
	}
	/**
	 * 根据查询条件查询用户数量
	 * @param pramMap 查询条件
	 * @return 返回用户数量
	 */

	 
	public Integer selectUserInfoCount(Map<String, Object> pramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public void insertUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		
	}

	 
	public UserInfo selectUserInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public void updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		
	}

	 
	public void delUserInfo(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
