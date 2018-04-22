package com.keji.washer.model.dto;


/**
 * 报修 dto
 *
 * @author Ice_Dog
 */
public class RepairInfo {
    private Integer id;
    private WasherInfo washerId;
    private UserInfo userId;
    private String message;
    private Boolean isHandle;

    @Override
    public String toString() {
        return "RepairInfo{" +
                "id=" + id +
                ", washerId=" + washerId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", isHandle=" + isHandle +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WasherInfo getWasherId() {
        return washerId;
    }

    public void setWasherId(WasherInfo washerId) {
        this.washerId = washerId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getHandle() {
        return isHandle;
    }

    public void setHandle(Boolean handle) {
        isHandle = handle;
    }
}
