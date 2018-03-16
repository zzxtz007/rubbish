package com.keji.washer.model.bo;

import com.keji.washer.model.po.StoriedPo;

import java.sql.Date;

/**
 * 洗衣机
 *
 * @author ICE_DOG
 */
public class WasherBo {
	private Integer id;
	private StoriedPo storiedId;
	private Integer status;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "WasherBo{" +
				"id=" + id +
				", storiedId=" + storiedId +
				", status=" + status +
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

	public StoriedPo getStoriedId() {
		return storiedId;
	}

	public void setStoriedId(StoriedPo storiedId) {
		this.storiedId = storiedId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
