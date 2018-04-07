package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.GetUserInfo;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 订单 controller
 *
 * @author Ice_Dog
 */
@Controller
@RequestMapping(value = {"/order"}, produces = "application/json;charset=utf-8")
@ResponseBody
public class OrderController {
	private static final Gson GSON = new Gson();

	@Resource
	private OrderService orderService;

	/**
	 * 添加订单
	 *
	 * @param userId   用户 id
	 * @param washerId 洗衣机 id
	 * @param modeId   模式 id
	 * @param uid      session 的用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.POST})
	@NeedLogin
	@GetUserInfo
	public String insert(String userId, Integer washerId, Integer modeId, String uid) throws Throwable {
		return GSON.toJson(orderService.insert(userId, washerId, modeId, uid));
	}

	/**
	 * 关闭订单
	 *
	 * @param id  订单 id
	 * @param uid session 的用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(value = {"/close"}, method = {RequestMethod.PUT})
	@NeedLogin
	@GetUserInfo
	public String close(Integer id, String uid) throws Throwable {
		return GSON.toJson(orderService.update(id, 2, uid));
	}

	/**
	 * 确认订单
	 *
	 * @param id  订单 id
	 * @param uid session 的用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(value = {"/check"}, method = {RequestMethod.PUT})
	@NeedLogin
	@GetUserInfo
	public String check(Integer id, String uid) throws Throwable {
		return GSON.toJson(orderService.update(id, 0, uid));
	}

}
