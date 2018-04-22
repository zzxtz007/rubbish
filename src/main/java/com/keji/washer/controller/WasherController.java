package com.keji.washer.controller;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.NeedLogin;
import com.keji.washer.service.AppraisalService;
import com.keji.washer.service.WasherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    private AppraisalService appraisalService;



    /**
     * 根据洗衣机 id 查询评价
     *
     * @param washerId 洗衣机 id
     * @return 响应码 + 评价 dto
     * @throws Throwable 异常时抛出
     */
    @RequestMapping(value = "/{washerId}/appraisal", method = {RequestMethod.GET})
    public String list(@PathVariable Integer washerId) throws Throwable {
        return GSON.toJson(appraisalService.listByWasherId(washerId));
    }
}
