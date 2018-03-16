package com.keji.washer.model.po;

import java.sql.Date;

/**
 * 报修
 *
 * @author ICE_DOG
 */
public class RepairPo {
	private Integer id;
	private Integer washerId;
	private String userId;
	private String message;
	private Boolean isHandle;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "RepairPo{" +
				"id=" + id +
				", washerId=" + washerId +
				", userId='" + userId + '\'' +
				", message='" + message + '\'' +
				", isHandle=" + isHandle +
				", insertUser='" + insertUser + '\'' +
				", insertTime=" + insertTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}

	public Boolean getIsHandle() {
		return isHandle;
	}

	public void setIsHandle(Boolean handle) {
		isHandle = handle;
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
