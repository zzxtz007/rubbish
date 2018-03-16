package com.keji.washer.service;

import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.common.utils.Response;

import javax.servlet.http.HttpSession;

/**
 * 会话 service
 *
 * @author ICE_DOG
 */
public interface SessionService {

	/**
	 * 用户登录
	 *
	 * @param phone    用户输入的手机号
	 * @param password 用户输入的密码
	 * @param session  会话对象
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response userLogin(String phone, String password, HttpSession session) throws Throwable;

	/**
	 * 管理员登录
	 *
	 * @param username 用户输入的账号
	 * @param password 用户输入的密码
	 * @param session  会话对象
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response operatorLogin(String username, String password, HttpSession session) throws Throwable;

	/**
	 * 登出
	 *
	 * @param session 会话对象
	 * @param uid     当前用户 ID
	 * @param role    当前用户角色
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response logout(HttpSession session, String uid, UserRoleEnum role) throws Throwable;
}
