package com.keji.washer.service.impl;

import com.keji.washer.common.exception.IllegalAccessException;
import com.keji.washer.common.utils.Password;
import com.keji.washer.common.utils.PasswordUtils;
import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.UserMapper;
import com.keji.washer.model.bo.StoriedBo;
import com.keji.washer.model.bo.UserBo;
import com.keji.washer.model.dto.StoriedInfo;
import com.keji.washer.model.dto.UserInfo;
import com.keji.washer.model.po.UserPo;
import com.keji.washer.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用户 service 实现类
 *
 * @author ICE_DOG
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper userMapper;

	@Override
	public Response registered(String name, String phone, String password) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (name == null || phone == null || password == null) {
			return new Response(3);
		}
		Password realPassword = PasswordUtils.newHash(password);
		UserPo userPo = new UserPo();
		userPo.setPhone(phone);
		userPo.setName(name);
		userPo.setPwdHash(realPassword.getHash());
		userPo.setSalt(realPassword.getSalt());
		userPo.setInsertUser("o_1");
		userPo.setUpdateUser("o_1");
		int num = userMapper.insert(userPo);
		if (num != 1) {
			throw new IllegalAccessException("数据库错误!");
		}
		return new Response(0);
	}

	@Override
	public Response update(String id, String name, Integer storied, BigDecimal money,
			String uid) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null || uid == null) {
			return new Response(3);
		}
		UserPo userPo = new UserPo();
		userPo.setId(id);
		userPo.setName(name);
		userPo.setBalance(money);
		userPo.setStoriedId(storied);
		userPo.setUpdateUser(uid);
		int num = userMapper.update(userPo);
		if (num != 1) {
			throw new IllegalAccessException("数据库错误!");
		}
		return new Response(0);
	}

	@Override
	public Response get(String id) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null) {
			return new Response(3);
		}
		UserPo userPo = new UserPo();
		userPo.setId(id);
		UserBo userBo = userMapper.get(userPo);
		if (userBo == null) {
			throw new IllegalAccessException("数据库错误!");
		}
		StoriedBo storiedBo = new StoriedBo();
		storiedBo.setId(userBo.getStoriedId().getId());
		storiedBo.setNumber(userBo.getStoriedId().getNumber());
		UserInfo userInfo = new UserInfo(userBo.getId(), userBo.getName(), userBo.getPhone(),
				new StoriedInfo(storiedBo), userBo.getBalance());
		return new Response(0).add("info", userInfo);
	}
}
