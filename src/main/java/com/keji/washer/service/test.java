package com.keji.washer.service;

import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.*;
import com.keji.washer.model.bo.*;
import com.keji.washer.model.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("test")
public class test {
	@Resource
	private ModeMapper modeMapper;

	@Resource
	private OperatorMapper operatorMapper;

	@Resource
	private UserMapper userMapper;

	@Resource
	private StoriedMapper storiedMapper;

	@Resource
	private WasherMapper washerMapper;

	@Resource
	private OrderMapper orderMapper;

	@Resource
	private RepairMapper repairMapper;
	@Resource
	private AppraisalMapper appraisalMapper;

	Response listMode() {
		List<ModeBo> modeBos = modeMapper.list();
		return new Response(0).add("info", modeBos);
	}

	Response listStoried() {
		List<StoriedBo> storiedBos = storiedMapper.list();
		return new Response(0).add("info", storiedBos);
	}

	Response getOperator(OperatorPo operatorPo) {
		OperatorBo operatorBo = operatorMapper.get(operatorPo);
		return new Response(0).add("info", operatorBo);
	}

	Response insertUser(UserPo userPo) {
		int num = userMapper.insert(userPo);
		return new Response(0).add("info", num);
	}

	Response updateUser(UserPo userPo) {
		int num = userMapper.update(userPo);
		return new Response(0).add("info", num);
	}

	Response getUser(UserPo userPo) {
		UserBo user = userMapper.get(userPo);
		return new Response(0).add("info", user);
	}

	Response insertWasher(WasherPo washerPo) {
		int num = washerMapper.insert(washerPo);
		return new Response(0).add("info", num);
	}

	Response updateWasher(WasherPo washerPo) {
		int num = washerMapper.update(washerPo);
		return new Response(0).add("info", num);
	}

	Response listWasher(WasherPo washerPo, int startIndex, int count) {
		List<WasherBo> washerBos = washerMapper.list(washerPo, startIndex, count);
		return new Response(0).add("info", washerBos);
	}

	Response insertOrder(OrderPo orderPo) {
		int num = orderMapper.insert(orderPo);
		return new Response(0).add("info", num);
	}

	Response listOrder(OrderPo orderPo) {
		List<OrderBo> num = orderMapper.list(orderPo,1,1);
		return new Response(0).add("info", num);
	}

	Response getOrder(OrderPo orderPo) {
		OrderBo num = orderMapper.get(orderPo);
		return new Response(0).add("info", num);
	}

	Response insertAppraisal(AppraisalPo appraisalPo) {
		int num = appraisalMapper.insert(appraisalPo);
		return new Response(0).add("info", num);
	}

	Response getAppraisal(AppraisalPo appraisalPo) {
		AppraisalBo num = appraisalMapper.get(appraisalPo);
		return new Response(0).add("info", num);
	}

	Response listAppraisal(AppraisalPo appraisalPo, Integer washerId) {
		List<AppraisalBo> num = appraisalMapper.list(appraisalPo, washerId);
		return new Response(0).add("info", num);
	}
	Response insertRepair(RepairPo repairPo) {
		int num = repairMapper.insert(repairPo);
		return new Response(0).add("info", num);
	}

	Response updateRepair(RepairPo repairPo) {
		int num = repairMapper.update(repairPo);
		return new Response(0).add("info", num);
	}

	Response listRepair(RepairPo repairPo) {
		List<RepairBo> num = repairMapper.list(repairPo);
		return new Response(0).add("info", num);
	}

}
