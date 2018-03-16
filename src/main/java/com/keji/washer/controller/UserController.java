package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.GetUserInfo;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.common.annotation.NeedRole;
import com.keji.washer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用户 controller
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=utf-8")
@ResponseBody
public class UserController {
	private static final Gson GSON = new Gson();
	@Resource
	private UserService userService;

	/**
	 * 注册用户
	 *
	 * @param name     用户名
	 * @param password 密码
	 * @param phone    手机号
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.POST})
	public String registered(String name, String phone, String password) throws Throwable {
		return GSON.toJson(userService.registered(name, phone, password));
	}

	/**
	 * 充值金额
	 *
	 * @param id    用户 id
	 * @param money 充值的金额
	 * @param uid   当前登陆用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.PUT}, value = "/{id}/recharge")
	@NeedLogin
	@GetUserInfo
	public String recharge(@PathVariable String id, BigDecimal money, String uid) throws Throwable {
		return GSON.toJson(userService.update(id, null, null, money, uid));
	}

	/**
	 * 修改个人信息
	 *
	 * @param id      用户 id
	 * @param name    用户名称
	 * @param storied 用户所属楼层
	 * @param uid     当前登陆用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.PUT}, value = "/{id}/modify")
	@NeedLogin
	@GetUserInfo
	public String modify(@PathVariable String id, String name, Integer storied, String uid) throws
			Throwable {
		return GSON.toJson(userService.update(id, name, storied, null, uid));
	}

	/**
	 * 查询个人信息
	 *
	 * @param id      用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.GET}, value = "/{id}")
	@NeedLogin
	public String get(@PathVariable String id)throws Throwable{
		return GSON.toJson(userService.get(id));
	}
}
