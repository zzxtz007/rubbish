package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.GetUserInfo;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.common.annotation.NeedRole;
import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.service.AppraisalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 评价 service
 */
@Controller
@RequestMapping(value = "/appraisal", produces = "application/json;charset=utf-8")
@ResponseBody
public class AppraisalController {
    private static final Gson GSON = new Gson();

    @Resource
    private AppraisalService appraisalService;

    /**
     * 添加新的评价
     *
     * @param orderId 订单 id
     * @param message 评价信息
     * @param userId  用户 id
     * @param uid     session 中的用户 id
     * @return 响应码
     * @throws Throwable 发生异常时抛出
     */
    @RequestMapping(method = RequestMethod.POST)
    @NeedLogin
    @NeedRole(UserRoleEnum.USER)
    @GetUserInfo
    public String insert(Integer orderId, String message, String userId, String uid) throws
            Throwable {
        return GSON.toJson(appraisalService.insert(orderId, message, userId, uid));
    }

}
