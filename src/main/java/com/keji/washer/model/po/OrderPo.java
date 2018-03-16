package com.keji.washer.model.po;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单
 *
 * @author ICE_DOG
 */
public class OrderPo {
	private Integer id;
	private Integer washerId;
	private String userId;
	private Integer modeId;
	private Integer status;
	private BigDecimal money;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "OrderPo{" +
				"id=" + id +
				", washerId=" + washerId +
				", userId='" + userId + '\'' +
				", modeId=" + modeId +
				", status=" + status +
				", money=" + money +
				", insertUser='" + insertUser + '\'' +
				", insertTime=" + insertTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWasherId() {
		return washerId;
	}

	public void setWasherId(Integer washerId) {
		this.washerId = washerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getModeId() {
		return modeId;
	}

	public void setModeId(Integer modeId) {
		this.modeId = modeId;
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
