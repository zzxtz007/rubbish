package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.GetUserInfo;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.common.enumeration.IllegalAccessTypeEnum;
import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.common.exception.IllegalAccessException;
import com.keji.washer.common.utils.Response;
import com.keji.washer.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Session
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/session", produces = "application/json;charset=utf-8")
@ResponseBody
public class SessionController {
	private static final Gson GSON = new Gson();

	@Resource
	private SessionService sessionService;

	/**
	 * 登录
	 *
	 * @param role     角色
	 * @param username 用户名（For operators）
	 * @param phone    手机号码（For users）
	 * @param password 密码（For operators and users）
	 * @param session  会话对象
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(String role, String username, String phone, String password, HttpSession
			session) throws Throwable {
		switch (role) {
			case "user": {
				return GSON.toJson(sessionService.userLogin(phone, password, session));
			}
			case "operator": {
				return GSON.toJson(sessionService.operatorLogin(username, password, session));
			}
			default: {
				throw new IllegalAccessException(IllegalAccessTypeEnum.ILLEGAL_PARAM);
			}
		}
	}

	/**
	 * 登出
	 *
	 * @param session 会话对象
	 * @param uid     当前用户 ID
	 * @param role    当前用户角色
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@NeedLogin
	@GetUserInfo
	public String logout(HttpSession session, String uid, UserRoleEnum role) throws Throwable {
		return GSON.toJson(sessionService.logout(session, uid, role));
	}

	/**
	 * 检查会话状态
	 *
	 * @param uid  当前用户 ID
	 * @param role 当前用户角色
	 * @return 响应值
	 */
	@RequestMapping(method = RequestMethod.GET)
	@GetUserInfo
	public String checkSession(String uid, UserRoleEnum role) {
		HttpSession s =
				((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
						.getRequest().getSession();
		if (uid == null) {
			return GSON.toJson(new Response(2));
		} else {
			return GSON.toJson(new Response(0).add("uid", uid).add("role", role.getValue()));
		}
	}
}
