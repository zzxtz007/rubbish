package com.keji.washer.model.dto;


/**
 * 评价 dto
 *
 * @author Ice_Dog
 */
public class AppraisalInfo {
    private Integer id;
    private OrderInfo orderId;
    private UserInfo userId;
    private String message;

    @Override
    public String toString() {
        return "AppraisalInfo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderInfo getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderInfo orderId) {
        this.orderId = orderId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
