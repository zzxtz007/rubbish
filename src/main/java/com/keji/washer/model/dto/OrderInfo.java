package com.keji.washer.model.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单 dto
 *
 * @author Ice_Dog
 */
public class OrderInfo {
	private Integer id;
	private Integer status;
	private BigDecimal price;
	private String washerName;
	private Date createTime;

	@Override
	public String toString() {
		return "OrderInfo{" +
				"id=" + id +
				", status=" + status +
				", price=" + price +
				", washerName='" + washerName + '\'' +
				", createTime=" + createTime +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
