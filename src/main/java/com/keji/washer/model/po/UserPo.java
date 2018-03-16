package com.keji.washer.model.po;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 用户
 *
 * @author ICE_DOG
 */
public class UserPo {
	private String id;
	private String name;
	private String phone;
	private String salt;
	private String pwdHash;
	/**
	 * 所属楼号
	 */
	private Integer storiedId;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	private Boolean isDeleted;

	@Override
	public String toString() {
		return "UserPo{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", salt='" + salt + '\'' +
				", pwdHash='" + pwdHash + '\'' +
				", storiedId=" + storiedId +
				", balance=" + balance +
				", insertUser='" + insertUser + '\'' +
				", insertTime=" + insertTime +
				", updateUser='" + updateUser + '\'' +
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Integer getStoriedId() {
		return storiedId;
	}

	public void setStoriedId(Integer storiedId) {
		this.storiedId = storiedId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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
