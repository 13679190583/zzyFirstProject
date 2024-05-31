package com.example.zzyfirstproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class UserVo implements Serializable {
    public Integer id;
    public String userName;
    public String password;
    public Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date birthday;
    public Integer deptId;
    public String deptName;
    public String description;
    public Integer address;

    public UserVo() {
    }

    public UserVo(Integer id, String userName, String password, Integer gender, Date birthday, Integer deptId, String deptName, String description, Integer address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.deptId = deptId;
        this.deptName = deptName;
        this.description = description;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }
}
