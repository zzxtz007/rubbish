package com.keji.washer.model.dto;

import com.keji.washer.model.po.StoriedPo;

import java.math.BigDecimal;

/**
 * 用户 info
 *
 * @author ICE_DOG
 */
public class UserInfo {
	private String id;
	private String name;
	private String phone;
	/**
	 * 所属楼号
	 */
	private StoriedInfo storied;
	/**
	 * 余额
	 */
	private BigDecimal balance;

	public UserInfo(String id, String name, String phone, StoriedInfo storied,
			BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.storied = storied;
		this.balance = balance;
	}

	public UserInfo() {
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", storied=" + storied +
				", balance=" + balance +
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

	public StoriedInfo getStoried() {
		return storied;
	}

	public void setStoried(StoriedInfo storied) {
		this.storied = storied;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
