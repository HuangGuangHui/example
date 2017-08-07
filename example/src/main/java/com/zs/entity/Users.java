package com.zs.entity;

import java.math.BigDecimal;

public class Users {
    private BigDecimal id;

    private String usernumber;

    private String userpassword;

    private String name;

    private BigDecimal rId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber == null ? null : usernumber.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getrId() {
        return rId;
    }

    public void setrId(BigDecimal rId) {
        this.rId = rId;
    }
}