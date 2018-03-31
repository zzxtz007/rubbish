package com.keji.washer.service;

import com.keji.washer.common.utils.Response;

/**
 * 订单 service
 *
 * @author ICE_DOG
 */
public interface OrderService {

	/**
	 * 插入订单
	 *
	 * @param id       用户 id
	 * @param washerId 洗衣机 id
	 * @param modeId   洗衣模式
	 * @param uid      获取的用户 id
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response insert(String id, Integer washerId, Integer modeId, String uid) throws Throwable;

	/**
	 * 修改订单
	 *
	 * @param id     订单 id
	 * @param status 订单状态
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response update(Integer id, Integer status, String uid) throws Throwable;

	/**
	 * 获取单条订单
	 *
	 * @param id 订单 id
	 * @return 响应值+订单信息
	 * @throws Throwable 发生异常时抛出
	 */
	Response get(Integer id) throws Throwable;

	/**
	 * 获取用户的订单
	 *
	 * @param userId  用户 id
	 * @param pageNum 查询页数
	 * @param count   查询个数
	 * @return 响应值+订单信息
	 * @throws Throwable 发生异常时抛出
	 */
	Response listByUserId(String userId, Integer pageNum, Integer count) throws Throwable;
}
