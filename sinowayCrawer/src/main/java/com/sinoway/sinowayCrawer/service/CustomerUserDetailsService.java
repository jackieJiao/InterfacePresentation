package com.sinoway.sinowayCrawer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.sinowayCrawer.entitys.User;
import com.sinoway.sinowayCrawer.mapper.UserMapper;



@Service
@Transactional
public class CustomerUserDetailsService implements UserDetailsService {

	protected Logger logger = Logger.getLogger("service");


	
	@Resource
	private UserMapper userMapper;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		UserDetails userDetail = null;
		User user=null;
		try {

			// 搜索数据库以匹配用户登录名.
			// 我们可以通过dao使用JDBC来访问数据库
			//User user = userDAO.getDatabase(username);
			
		    user =userMapper.checkUser(username);
			// Populate the Spring User object with details from the User
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the
			// correct
			// role type
		    logger.debug(username);
			userDetail = new org.springframework.security.core.userdetails.User(user.getUsername(),
					user.getPassword().toLowerCase(), true, true, true, true, getAuthorities(user.getAccess()));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(username);
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		return userDetail;
	}

	/**
	 * 获得访问角色权限
	 * 
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(3);

		// 所有的用户默认拥有ROLE_USER权限
		logger.debug("Grant ROLE_USER to this user");
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		// 如果参数access为1.则拥有ROLE_ADMIN权限,
		if (access.compareTo(1) == 0) {
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));

		} 
		return authList;
	}

}
