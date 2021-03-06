package com.keji.washer.model.dto;

import com.keji.washer.model.bo.StoriedBo;

/**
 * 楼号 dto
 *
 * @author ICE_DOG
 */
public class StoriedInfo {
	private Integer id;
	private Integer number;
	private Integer left;

	public StoriedInfo() {
	}

	public StoriedInfo(StoriedBo storiedBo) {
		this.id = storiedBo.getId();
		this.number = storiedBo.getNumber();
	}

	@Override
	public String toString() {
		return "StoriedInfo{" +
				"id=" + id +
				", number=" + number +
				", left=" + left +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
