package com.keji.washer.service;

import com.keji.washer.common.utils.Response;

/**
 * 模式 service
 *
 * @author ICE_DOG
 */
public interface ModeService {

	/**
	 * 查询所有模式
	 *
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	Response list() throws Throwable;
}
