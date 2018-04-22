package com.keji.washer.service;

import com.keji.washer.common.utils.Response;

/**
 * 评价 service
 *
 * @author Ice_Dog
 */
public interface AppraisalService {

    /**
     * 添加评价信息
     *
     * @param orderId 订单id
     * @param message 评价内容
     * @param userId  用户 id
     * @param uid     session 中的用户id
     * @return 响应码
     * @throws Throwable 发生异常时抛出
     */
    Response insert(Integer orderId, String message, String userId, String uid) throws Throwable;

    /**
     * 查询洗衣机下面的评价
     *
     * @param washerId 洗衣机 id
     * @return 响应码
     * @throws Throwable 发生异常时抛出
     */
    Response listByWasherId(Integer washerId) throws Throwable;
}
