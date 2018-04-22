package com.keji.washer.service;

import com.keji.washer.common.utils.Response;

import java.math.BigDecimal;

/**
 * 用户 service
 *
 * @author ICE_DOG
 */
public interface UserService {
	/**
	 * 用户注册
	 *
	 * @param name     用户名
	 * @param phone    手机号
	 * @param password 密码
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response registered(String name, String phone, String password,Integer storied) throws Throwable;

	/**
	 * 修改用户信息
	 *
	 * @param id      用户 id 必选
	 * @param name    用户姓名 可选
	 * @param storied 用户所属楼层 可选
	 * @param money   充值金额 可选
	 * @param uid     当前用户的 id 必选
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response update(String id, String name, Integer storied,String phone,String password,String oldPwd, BigDecimal money,
			String uid) throws
			Throwable;

	/**
	 * 查询用户信息
	 *
	 * @param id 用户 id
	 * @return 响应值 + 用户 dto
	 * @throws Throwable 发生异常时抛出
	 */
	Response get(String id) throws Throwable;
}
