package com.sinoway.sinowayCrawer.service;

import com.sinoway.sinowayCrawer.entitys.UserInfo;

public interface LoginService {

	/**
	 * 
	 * 功能:用户登录 <br/>
	 * 参数：用户名和密码 <br/>
	 * 返回结果：用户信息 或者NULL<br/>
	 * 异常信息： <br/>
	 * 创建人: 刘晓东 <br/>
	 * 创建时间: 2014年2月19日 <br/>
	 * 修改人 : 修改时间 : 修改备注:
	 */
	public abstract UserInfo selectUserForLogin(String userName, String userPsw);

}