package com.mark.springbootmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    private Integer userId;
    private String email;


    @JsonIgnore
    private String password;

    private Date createDate;
    private Date lasModifiedDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLasModifiedDate() {
        return lasModifiedDate;
    }

    public void setLasModifiedDate(Date lasModifiedDate) {
        this.lasModifiedDate = lasModifiedDate;
    }
}
