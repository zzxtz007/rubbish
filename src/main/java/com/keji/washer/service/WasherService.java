package com.keji.washer.service;


import com.keji.washer.common.utils.Response;

/**
 * 洗衣机 service
 *
 * @author ICE_DOG
 */
public interface WasherService {

	/**
	 * 根据条件查询洗衣机
	 *
	 * @param storiedId 楼号
	 * @param status    状态
	 * @param pageNum 查询页数
	 * @param count   每页个数
	 * @return 相应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response listByStoried(Integer storiedId, Integer status, Integer pageNum, Integer count) throws
			Throwable;
}
