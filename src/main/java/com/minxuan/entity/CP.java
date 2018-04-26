package com.minxuan.entity;

import java.io.Serializable;

public class CP implements Serializable{


    private static final long serialVersionUID = -1504194748698259790L;
    private String code;

    private Integer id;

    private String cpName;

    private String orderNum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
