package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.service.ModeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 模式 controller
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/mode", produces = "application/json;charset=utf-8")
@ResponseBody
public class ModeController {
	private static final Gson GSON = new Gson();

	@Resource
	private ModeService modeService;

	/**
	 * 查询所有模式
	 *
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = {RequestMethod.GET})
	@NeedLogin
	public String list() throws Throwable {
		return GSON.toJson(modeService.list());
	}
}
