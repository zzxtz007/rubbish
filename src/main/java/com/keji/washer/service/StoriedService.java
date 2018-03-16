package com.keji.washer.service;

import com.keji.washer.common.utils.Response;

/**
 * 楼号 service
 *
 * @author ICE_DOG
 */
public interface StoriedService {
	/**
	 * 查询所有楼号
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response list() throws Throwable;
}
