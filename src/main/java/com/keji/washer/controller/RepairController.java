package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.GetUserInfo;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.common.annotation.NeedRole;
import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 报修 controller
 *
 * @author Ice_Dog
 */
@Controller
@RequestMapping(value = "/repair", produces = "application/json;charset=utf-8")
@ResponseBody
public class RepairController {
    private static final Gson GSON = new Gson();

    @Resource
    private RepairService repairService;

    @NeedLogin
    @NeedRole(value = {UserRoleEnum.OPERATOR})
    @RequestMapping(method = RequestMethod.GET)
    public String list(String userId, Boolean isHandle) throws Throwable {
        return GSON.toJson(repairService.list(userId, isHandle));
    }

    @NeedLogin
    @NeedRole(value = {UserRoleEnum.OPERATOR})
    @GetUserInfo
    @RequestMapping(method = RequestMethod.PUT)
    public String update(Integer id, String uid) throws Throwable {
        return GSON.toJson(repairService.update(id, true, uid));
    }

    @NeedLogin
    @NeedRole(value = {UserRoleEnum.USER})
    @GetUserInfo
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Integer washerId, String userId, String message, String uid) throws
            Throwable {
        return GSON.toJson(repairService.insert(washerId, userId, message, uid));
    }
}
