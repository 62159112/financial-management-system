package com.chongdong.financialmanagementsystem.model;

public class Outbound {
    private Integer id;
    private Integer quantity;
    private String user;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Outbound{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", user='" + user + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
