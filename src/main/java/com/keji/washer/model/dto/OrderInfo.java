package com.keji.washer.model.dto;

import java.math.BigDecimal;

/**
 * 订单 dto
 *
 * @author Ice_Dog
 */
public class OrderInfo {
	private Integer id;
	private Integer status;
	private BigDecimal price;
	private StoriedInfo storiedInfo;

	@Override
	public String toString() {
		return "OrderInfo{" +
				"id=" + id +
				", status=" + status +
				", price=" + price +
				", storiedInfo=" + storiedInfo +
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

	public StoriedInfo getStoriedInfo() {
		return storiedInfo;
	}

	public void setStoriedInfo(StoriedInfo storiedInfo) {
		this.storiedInfo = storiedInfo;
	}
}
