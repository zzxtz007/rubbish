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
	public Response registered(String name, String phone, String password,Integer storied) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (name == null || phone == null || password == null || storied==null) {
			return new Response(3);
		}
		Password realPassword = PasswordUtils.newHash(password);
		UserPo userPo = new UserPo();
		userPo.setPhone(phone);
		userPo.setName(name);
		userPo.setPwdHash(realPassword.getHash());
		userPo.setSalt(realPassword.getSalt());
		userPo.setStoriedId(storied);
		userPo.setInsertUser("o_1");
		userPo.setUpdateUser("o_1");
		int num = userMapper.insert(userPo);
		if (num != 1) {
			throw new IllegalAccessException("数据库错误!");
		}
		return new Response(0);
	}

	@Override
	public Response update(String id, String name, Integer storied,String phone,String password,String oldPwd, BigDecimal money,
			String uid) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null || uid == null) {
			return new Response(3);
		}
		UserPo userPo = new UserPo();
		userPo.setId(id);
		//查询用户
		UserBo userBo = userMapper.get(userPo);
		if (userBo == null) {
			throw new IllegalAccessException("数据库未查到此用户!");
		}
		//存在充值的金额并且不小于0 否则 返回3
//		if(money!=null){
//			if(money.compareTo(new BigDecimal(0))<=0){
//				return new Response(3);
//			}
//		}
		BigDecimal y=userBo.getBalance();
		BigDecimal blance=money.add(y);
		userPo.setName(name);
		userPo.setBalance(blance);
		userPo.setStoriedId(storied);
		userPo.setUpdateUser(uid);
		userPo.setPhone(phone);
		//若旧密码和新密码都存在 则修改密码
		if (oldPwd != null && password != null) {
			//判断密码是否正确
			String oldHash = PasswordUtils.hash(oldPwd,userBo.getSalt());
			if (oldHash.equals(userBo.getPwdHash())){
				//修改密码
				Password pwd = PasswordUtils.newHash(password);
				userPo.setSalt(pwd.getSalt());
				userPo.setPwdHash(pwd.getHash());
			} else {
				return new Response(1);
			}
		}
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
