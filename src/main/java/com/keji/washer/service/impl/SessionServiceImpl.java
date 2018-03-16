package com.keji.washer.service.impl;

import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.common.utils.PasswordUtils;
import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.OperatorMapper;
import com.keji.washer.dal.UserMapper;
import com.keji.washer.model.bo.OperatorBo;
import com.keji.washer.model.bo.UserBo;
import com.keji.washer.model.po.OperatorPo;
import com.keji.washer.model.po.UserPo;
import com.keji.washer.service.SessionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 会话 service 实现类
 *
 * @author ICE_DOG
 */
@Service
public class SessionServiceImpl implements SessionService {
	private static final Logger LOGGER = Logger.getLogger(SessionServiceImpl.class);
	private static final int SESSION_TIMEOUT = 4 * 60 * 60;
	@Resource
	private UserMapper userMapper;
	@Resource
	private OperatorMapper operatorMapper;

	@Override
	public Response userLogin(String phone, String password, HttpSession session) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (phone == null || password == null || session == null) {
			return new Response(3);
		}
		//获取phone对应的数据
		UserPo userPo = new UserPo();
		userPo.setPhone(phone);
		UserBo userBo = userMapper.get(userPo);
		//查询到的数据为空 返回 4
		if (userBo == null) {
			LOGGER.error("获取到的 UserBo 为空");
			return new Response(4);
		}
		String realPassword = userBo.getPwdHash();
		String salt = userBo.getSalt();
		String passwordHash = PasswordUtils.hash(password, salt);
		if (passwordHash.equals(realPassword)) {
			session.setMaxInactiveInterval(SESSION_TIMEOUT);
			session.setAttribute("uid", userBo.getId());
			session.setAttribute("role", UserRoleEnum.USER);
			LOGGER.info("用户登录, UID=" + session.getAttribute("uid"));
			return new Response(0);
		} else {
			LOGGER.error("账号密码错误");
			return new Response(5);
		}
	}

	@Override
	public Response operatorLogin(String username, String password, HttpSession session) throws
			Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (username == null || password == null || session == null) {
			return new Response(3);
		}
		//获取username对应的数据
		OperatorPo operatorPo = new OperatorPo();
		operatorPo.setUsername(username);
		OperatorBo operatorBo = operatorMapper.get(operatorPo);
		//查询到的数据为空 返回 4
		if (operatorBo == null) {
			LOGGER.error("获取到的 OperatorBo 为空");
			return new Response(4);
		}
		String realPassword = operatorBo.getPwdHash();
		String salt = operatorBo.getSalt();
		String passwordHash = PasswordUtils.hash(password, salt);
		if (passwordHash.equals(realPassword)) {
			session.setMaxInactiveInterval(SESSION_TIMEOUT);
			session.setAttribute("uid", operatorBo.getId());
			session.setAttribute("role", UserRoleEnum.OPERATOR);
			LOGGER.info("用户登录, UID=" + session.getAttribute("uid"));
			return new Response(0);
		} else {
			LOGGER.error("账号密码错误");
			return new Response(5);
		}
	}

	@Override
	public Response logout(HttpSession session, String uid, UserRoleEnum role) throws Throwable {
		if (session == null) {
			return new Response(3);
		}

		LOGGER.info("用户登出, UID=" + uid + ", Role=" + role);
		session.invalidate();
		return new Response(0);
	}
}
