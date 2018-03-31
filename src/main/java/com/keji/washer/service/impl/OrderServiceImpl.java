package com.keji.washer.service.impl;

import com.keji.washer.common.exception.IllegalAccessException;
import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.ModeMapper;
import com.keji.washer.dal.OrderMapper;
import com.keji.washer.dal.WasherMapper;
import com.keji.washer.model.bo.ModeBo;
import com.keji.washer.model.bo.OrderBo;
import com.keji.washer.model.bo.WasherBo;
import com.keji.washer.model.dto.OrderInfo;
import com.keji.washer.model.po.ModePo;
import com.keji.washer.model.po.OrderPo;
import com.keji.washer.model.po.WasherPo;
import com.keji.washer.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单 service 实现
 *
 * @author Ice_Dog
 */
@Service
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

	@Transactional(rollbackFor = {IllegalAccessException.class})
	@Override
	public Response update(Integer id, Integer status, String uid) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null || status == null || uid == null) {
			return new Response(3);
		}
		OrderPo orderPo = new OrderPo();
		orderPo.setId(id);
		orderPo.setStatus(status);
		orderPo.setUpdateUser(uid);

		OrderBo orderBo = orderMapper.get(orderPo);
		WasherPo washerPo = new WasherPo();
		washerPo.setId(orderBo.getWasherId().getId());
		//根据修改的 status 进行相应的修改洗衣机状态
		switch (status) {
			//已支付 需要改变洗衣机状态设置为正在洗衣
			case 0:
				washerPo.setStatus(2);
				if (washerMapper.update(washerPo) != 1) {
					throw new IllegalAccessException("更新失败");
				}
				break;
			case 1:
				break;
			case 2:
				washerPo.setStatus(0);
				if (washerMapper.update(washerPo) != 1) {
					throw new IllegalAccessException("更新失败");
				}
				break;
			//胡乱输入
			default:
				return new Response(3);
		}
		if (orderMapper.update(orderPo) != 1) {
			throw new IllegalAccessException("更新订单数据异常");
		}
		return new Response(0);
	}

	@Override
	public Response get(Integer id) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (id == null) {
			return new Response(3);
		}
		OrderPo orderPo = new OrderPo();
		orderPo.setId(id);
		OrderBo orderBo = orderMapper.get(orderPo);
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(orderBo.getId());
		orderInfo.setPrice(orderBo.getMoney());
		orderInfo.setStatus(orderBo.getStatus());
		orderInfo.setWasherName(orderBo.getWasherId().getName());
		orderInfo.setCreateTime(orderBo.getInsertTime());
		return new Response(0).add("info", orderInfo);
	}

	@Override
	public Response list(String userId, Integer pageNum, Integer count) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (pageNum == null || count == null) {
			return new Response(3);
		}
		OrderPo orderPo = new OrderPo();
		orderPo.setUserId(userId);
		List<OrderBo> orderBos = orderMapper.list(orderPo, pageNum * count, count);
		List<OrderInfo> orderInfos = new ArrayList<>();
		for (OrderBo orderBo : orderBos) {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setId(orderBo.getId());
			orderInfo.setPrice(orderBo.getMoney());
			orderInfo.setStatus(orderBo.getStatus());
			orderInfo.setWasherName(orderBo.getWasherId().getName());
			orderInfo.setCreateTime(orderBo.getInsertTime());
			orderInfos.add(orderInfo);
		}
		return new Response(0).add("info", orderInfos);
	}
}
