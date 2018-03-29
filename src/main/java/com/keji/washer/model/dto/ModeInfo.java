package com.keji.washer.model.dto;

import java.math.BigDecimal;

/**
 * 模式 dto
 *
 * @author ICE_DOG
 */
public class ModeInfo {
	private Integer id;
	private String type;
	private BigDecimal price;
	private Integer washerTime;

	public ModeInfo() {
	}

	public ModeInfo(Integer id, String type, BigDecimal price, Integer washerTime) {
		this.id = id;
		this.type = type;
		this.price = price;
		this.washerTime = washerTime;
	}

	@Override
	public String toString() {
		return "ModeInfo{" +
				"id=" + id +
				", type='" + type + '\'' +
				", price=" + price +
				", washerTime=" + washerTime +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getWasherTime() {
		return washerTime;
	}

	public void setWasherTime(Integer washerTime) {
		this.washerTime = washerTime;
	}
}
