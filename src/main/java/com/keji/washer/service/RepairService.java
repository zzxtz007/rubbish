package com.keji.washer.service;

import com.keji.washer.common.utils.Response;


/**
 * 报修 service
 *
 * @author Ice_Dog
 */
public interface RepairService {

    /**
     * 按条件查询报修情况
     *
     * @param userId   用户 id
     * @param isHandle 是否处理
     * @return 响应码 + 报修 dto
     */
    Response list(String userId, Boolean isHandle) throws Throwable;

    /**
     * 修改报修情况
     *
     * @param id       报修 id
     * @param isHandle 是否处理
     * @return 响应码
     */
    Response update(Integer id, Boolean isHandle, String uid) throws Throwable;

    /**
     * 新增报修
     *
     * @param washerId 洗衣机 id
     * @param userId   用户 id
     * @param message  报修详情
     * @param uid      当前登录用户 id
     * @return 响应码
     */
    Response insert(Integer washerId, String userId, String message, String uid) throws Throwable;
}
