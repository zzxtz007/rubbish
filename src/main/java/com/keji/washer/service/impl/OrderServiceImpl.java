package com.keji.washer.service.impl;

import com.keji.washer.common.exception.IllegalAccessException;
import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.ModeMapper;
import com.keji.washer.dal.OrderMapper;
import com.keji.washer.dal.WasherMapper;
import com.keji.washer.model.bo.ModeBo;
import com.keji.washer.model.bo.WasherBo;
import com.keji.washer.model.po.ModePo;
import com.keji.washer.model.po.OrderPo;
import com.keji.washer.model.po.WasherPo;
import com.keji.washer.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单 service 实现
 *
 * @author Ice_Dog
 */
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;
	@Resource
	private WasherMapper washerMapper;

	@Resource
	private ModeMapper modeMapper;

	@Transactional(rollbackFor = {IllegalAccessException.class})
	@Override
	public Response insert(String id, Integer washerId, Integer modeId, String uid) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null || washerId == null || modeId == null || uid == null) {
			return new Response(3);
		}
		//判断洗衣机是否在工作
		WasherPo washerPo = new WasherPo();
		washerPo.setId(washerId);
		List<WasherBo> washerBos = washerMapper.list(washerPo, 0, 1);
		if (washerBos.isEmpty()) {
			return new Response(1);
		}
		WasherBo washerBo = washerBos.get(0);
		if (washerBo.getStatus() != 0) {
			return new Response(1);
		}
		//获取模式
		ModePo modePo = new ModePo();
		modePo.setId(modeId);
		ModeBo modeBo = modeMapper.get(modePo);
		if (modeBo == null) {
			return new Response(1);
		}
		//创建订单 设置订单状态为 未付款
		OrderPo orderPo = new OrderPo();
		orderPo.setStatus(1);
		orderPo.setModeId(modeId);
		orderPo.setMoney(modeBo.getPrice());
		orderPo.setUserId(id);
		orderPo.setInsertUser(uid);
		orderPo.setUpdateUser(uid);
		if (orderMapper.insert(orderPo) != 1) {
			throw new IllegalAccessException("插入错误！");
		}
		//修改洗衣机
		washerPo.setStatus(1);
		washerPo.setUpdateUser(uid);
		if (washerMapper.update(washerPo) != 1) {
			throw new IllegalAccessException("修改错误！");
		}
		return new Response(0);
	}

	@Override
	public Response update(Integer id, Integer status) throws Throwable {
		return null;
	}

	@Override
	public Response get(Integer id) throws Throwable {
		return null;
	}

	@Override
	public Response list(String userId, Integer pageNum, Integer count) throws Throwable {
		return null;
	}
}
