package com.keji.washer.service.impl;

import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.RepairMapper;
import com.keji.washer.model.bo.RepairBo;
import com.keji.washer.model.dto.RepairInfo;
import com.keji.washer.model.dto.UserInfo;
import com.keji.washer.model.dto.WasherInfo;
import com.keji.washer.model.po.RepairPo;
import com.keji.washer.model.po.UserPo;
import com.keji.washer.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Resource
    private RepairMapper repairMapper;

    @Override
    public Response list(String userId, Boolean isHandle) throws Throwable {
        RepairPo repairPo = new RepairPo();
        repairPo.setUserId(userId);
        repairPo.setIsHandle(isHandle);
        List<RepairBo> repairBos = repairMapper.list(repairPo);
        List<RepairInfo> repairInfos = new ArrayList<>();
        for (RepairBo repairBo : repairBos) {
            RepairInfo repairInfo = new RepairInfo();
            repairInfo.setId(repairBo.getId());
            repairInfo.setHandle(repairBo.getIsHandle());
            repairInfo.setMessage(repairBo.getMessage());
            UserPo userPo = repairBo.getUserId();
            UserInfo userInfo = new UserInfo(userPo.getId(), userPo.getName(), userPo.getPhone(),
                    null, userPo.getBalance());
            repairInfo.setUserId(userInfo);
            WasherInfo washerInfo = new WasherInfo();
            washerInfo.setId(repairBo.getWasherId().getId());
            washerInfo.setName(repairBo.getWasherId().getName());
            washerInfo.setStatus(repairBo.getWasherId().getStatus());
            repairInfo.setWasherId(washerInfo);
        }
        return new Response(0).add("info", repairInfos);
    }

    @Override
    public Response update(Integer id, Boolean isHandle, String uid) throws Throwable {
        if (id == null || isHandle == null || uid == null) {
            return new Response(3);
        }
        RepairPo repairPo = new RepairPo();
        repairPo.setId(id);
        repairPo.setIsHandle(isHandle);
        repairPo.setUpdateUser(uid);
        if (1 != repairMapper.update(repairPo)) {
            return new Response(1);
        }
        return new Response(0);
    }

    @Override
    public Response insert(Integer washerId, String userId, String message, String uid) throws
            Throwable {
        if (washerId == null || userId == null || message == null || uid == null) {
            return new Response(3);
        }
        RepairPo repairPo = new RepairPo();
        repairPo.setWasherId(washerId);
        repairPo.setUserId(userId);
        repairPo.setMessage(message);
        repairPo.setInsertUser(uid);
        repairPo.setUpdateUser(uid);
        if (1 != repairMapper.insert(repairPo)) {
            return new Response(1);
        }
        return new Response(0);
    }
}
