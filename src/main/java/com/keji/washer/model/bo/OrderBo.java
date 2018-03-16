package com.keji.washer.model.bo;

import com.keji.washer.model.po.ModePo;
import com.keji.washer.model.po.UserPo;
import com.keji.washer.model.po.WasherPo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单
 *
 * @author ICE_DOG
 */
public class OrderBo {
	private Integer id;
	private WasherPo washerId;
	private UserPo userId;
	private ModePo modeId;
	private Integer status;
	private BigDecimal money;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "OrderBo{" +
				"id=" + id +
				", washerId=" + washerId +
				", userId=" + userId +
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

	public WasherPo getWasherId() {
		return washerId;
	}

	public void setWasherId(WasherPo washerId) {
		this.washerId = washerId;
	}

	public UserPo getUserId() {
		return userId;
	}

	public void setUserId(UserPo userId) {
		this.userId = userId;
	}

	public ModePo getModeId() {
		return modeId;
	}

	public void setModeId(ModePo modeId) {
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
