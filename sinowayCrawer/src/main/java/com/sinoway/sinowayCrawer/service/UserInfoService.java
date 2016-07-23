package com.sinoway.sinowayCrawer.service;

import java.util.List;
import java.util.Map;

import com.sinoway.sinowayCrawer.entitys.UserInfo;





public interface UserInfoService {
	
	/**
	 * 根据查询条件查询用户信息
	 * @param pramMap 查询条件
	 * @param pageNum 当前页，为null时表示查询全部数据
	 * @param pageSize 分页大小
	 * @return 返回用户列表
	 */
	public abstract List<UserInfo> selectUserByCondition(Map<String, Object> pramMap,Integer pageNum, Integer pageSize);
	/**
	 * 根据查询条件查询用户数量
	 * @param pramMap 查询条件
	 * @return 返回用户数量
	 */
	public abstract Integer selectUserInfoCount(Map<String, Object> pramMap);
	/**
	 * 添加用户
	 * @param user 用户数据
	 */
	public abstract void insertUserInfo(UserInfo user);
	/**
	 * 查询用户
	 * @param id 用户ID
	 * @return 返回用户数据
	 */
	public abstract UserInfo selectUserInfo(Integer id);
	/**
	 * 更新用户数据中不为null的字段
	 * @param user 用户数据
	 */
	public abstract void updateUserInfo(UserInfo user);
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public abstract void delUserInfo(Integer id);

}
