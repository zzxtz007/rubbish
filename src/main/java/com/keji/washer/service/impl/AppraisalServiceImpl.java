package com.keji.washer.service.impl;

import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.AppraisalMapper;
import com.keji.washer.dal.OrderMapper;
import com.keji.washer.dal.WasherMapper;
import com.keji.washer.model.bo.AppraisalBo;
import com.keji.washer.model.bo.WasherBo;
import com.keji.washer.model.dto.AppraisalInfo;
import com.keji.washer.model.dto.UserInfo;
import com.keji.washer.model.po.AppraisalPo;
import com.keji.washer.model.po.WasherPo;
import com.keji.washer.service.AppraisalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppraisalServiceImpl implements AppraisalService {
    @Resource
    private AppraisalMapper appraisalMapper;

    @Resource
    private WasherMapper washerMapper;

    @Override
    public Response insert(Integer orderId, String message, String userId, String uid) throws
            Throwable {
        if (orderId == null || message == null || userId == null || uid == null) {
            return new Response(3);
        }
        AppraisalPo appraisalPo = new AppraisalPo();
        appraisalPo.setOrderId(orderId);
        appraisalPo.setMessage(message);
        appraisalPo.setUserId(userId);
        appraisalPo.setInsertUser(uid);
        appraisalPo.setUpdateUser(uid);
        if (1 != appraisalMapper.insert(appraisalPo)) {
            return new Response(1);
        }
        return new Response(0);
    }

    @Override
    public Response listByWasherId(Integer washerId) throws Throwable {
    	
        List<AppraisalInfo> appraisalInfos = new ArrayList<>();
        AppraisalPo appraisalPo = new AppraisalPo();
        List<AppraisalBo> appraisalBos = appraisalMapper.list(appraisalPo, washerId);
        for (AppraisalBo appraisalBo : appraisalBos) {
            AppraisalInfo appraisalInfo = new AppraisalInfo();
            appraisalInfo.setId(appraisalBo.getId());
            appraisalInfo.setMessage(appraisalBo.getMessage());
            UserInfo userInfo = new UserInfo();
            userInfo.setName(appraisalBo.getUserId().getName());
            appraisalInfo.setUserId(userInfo);
            appraisalInfos.add(appraisalInfo);
        }
        WasherPo washerPo = new WasherPo();
        washerPo.setId(washerId);
        WasherBo washerBo = washerMapper.get(washerPo);
        return new Response(0).add("info", appraisalInfos).add("washerInfo", washerBo);
    }
}
