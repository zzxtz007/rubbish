package com.keji.washer.model.bo;

import com.keji.washer.model.po.OrderPo;
import com.keji.washer.model.po.UserPo;

import java.sql.Date;

/**
 * 评价
 *
 * @author ICE_DOG
 */
public class AppraisalBo {
	private Integer id;
	private OrderPo orderId;
	private UserPo userId;
	private String message;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "AppraisalBo{" +
				"id=" + id +
				", orderId=" + orderId +
				", userId=" + userId +
				", message='" + message + '\'' +
				", insertUser='" + insertUser + '\'' +
				", insertTime=" + insertTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderPo getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderPo orderId) {
		this.orderId = orderId;
	}

	public UserPo getUserId() {
		return userId;
	}

	public void setUserId(UserPo userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean deleted) {
		isDeleted = deleted;
	}
}
