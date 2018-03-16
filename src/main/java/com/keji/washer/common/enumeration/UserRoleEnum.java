package com.keji.washer.common.enumeration;

/**
 * 用户角色枚举
 *
 * @author Ice_Dog
 */

public enum UserRoleEnum {
    /**
     * 用户
     */
    USER(1),


    /**
     * 运营方管理员
     */
    OPERATOR(2),

    /**
     * 运营方超级管理员
     */
    OPERATOR_ADMIN(4);

    private int value;

    /**
     * 私有构造
     *
     * @param value 枚举值
     */
    UserRoleEnum(int value) {
        this.value = value;
    }

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    public int getValue() {
        return value;
    }
}
