package com.example.zzyfirstproject.vo;

import com.example.zzyfirstproject.entity.User;

import java.io.Serializable;
import java.util.List;


public class DeptVo implements Serializable {
    private Integer id;
    private String deptName;
    private String description;
    private String address;
    private List<User> users;

    public DeptVo() {
    }

    public DeptVo(Integer id, String deptName, String description, String address, List<User> users) {
        this.id = id;
        this.deptName = deptName;
        this.description = description;
        this.address = address;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users +
                '}';
    }
}
