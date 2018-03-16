package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.service.WasherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 洗衣机 controller
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/washer", produces = "application/json;charset=utf-8")
@ResponseBody
public class WasherController {
	private static final Gson GSON = new Gson();

	@Resource
	private WasherService washerService;

	/**
	 * 根据楼号查询洗衣机
	 *
	 * @param storiedId 楼号
	 * @param status    状态
	 * @param pageNum   开始页
	 * @param count     每页个数
	 * @return 响应值 + 洗衣机 dto
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.GET})
	@NeedLogin
	public String listByStoried(Integer storiedId, Integer status, Integer pageNum,
			Integer count) throws Throwable {
		return GSON.toJson(washerService.listByStoried(storiedId, status, pageNum, count));
	}
}
