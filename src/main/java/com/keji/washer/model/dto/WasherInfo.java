package com.keji.washer.model.dto;


import com.keji.washer.model.bo.WasherBo;

/**
 * 洗衣机 dto
 *
 * @author ICE_DOG
 */
public class WasherInfo {
	private Integer id;
	private String name;
	private StoriedInfo storied;
	private Integer status;

	@Override
	public String toString() {
		return "WasherInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", storied=" + storied +
				", status=" + status +
				'}';
	}

	public WasherInfo() {
	}

	public WasherInfo(WasherBo washerBo, StoriedInfo storied) {
		this.id = washerBo.getId();
		this.storied = storied;
		this.status = washerBo.getStatus();
		this.name = washerBo.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StoriedInfo getStoried() {
		return storied;
	}

	public void setStoried(StoriedInfo storied) {
		this.storied = storied;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
