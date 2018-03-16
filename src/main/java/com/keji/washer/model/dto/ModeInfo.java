package com.keji.washer.model.dto;

/**
 * 模式 dto
 *
 * @author ICE_DOG
 */
public class ModeInfo {
	private Integer id;
	private String type;
	private Integer price;
	private Integer washerTime;

	public ModeInfo() {
	}

	public ModeInfo(Integer id, String type, Integer price, Integer washerTime) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getWasherTime() {
		return washerTime;
	}

	public void setWasherTime(Integer washerTime) {
		this.washerTime = washerTime;
	}
}
