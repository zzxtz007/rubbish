package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.service.StoriedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 楼号 controller
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/storied", produces = "application/json;charset=utf-8")
@ResponseBody
public class StoriedController {
	private static final Gson GSON = new Gson();

	@Resource
	private StoriedService storiedService;

	@RequestMapping(method = {RequestMethod.GET})
	@NeedLogin
	public String list() throws Throwable {
		return GSON.toJson(storiedService.list());
	}
}
