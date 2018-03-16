package com.keji.washer.model.bo;

import java.sql.Date;

/**
 * 管理员
 *
 * @author ICE_DOG
 */
public class OperatorBo {
	private String id;
	private String username;
	private String salt;
	private String pwdHash;
	private Date insertTime;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "OperatorBo{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", salt='" + salt + '\'' +
				", pwdHash='" + pwdHash + '\'' +
				", insertTime=" + insertTime +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
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
