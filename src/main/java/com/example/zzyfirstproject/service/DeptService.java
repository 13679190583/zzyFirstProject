package com.example.zzyfirstproject.service;

import com.example.zzyfirstproject.entity.Dept;
import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.mapper.DeptMapper;
import com.example.zzyfirstproject.mapper.UserMapper;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public int insertDept(Dept dept)
    {
        return deptMapper.insertDept(dept);
    }

    public int batchInsertDept(List<Dept> deptList)
    {

        return deptMapper.batchInsertDept(deptList);
    }

    public int delterDept(Integer id)
    {
        return deptMapper.delete(id);
    }


    public int batchDeleteDept(List<Integer> ids)
    {

        return deptMapper.batchDeleteDept(ids);
    }

    public int updateDept(Dept dept)
    {
        return deptMapper.updateDept(dept);
    }

    public Dept findDept(Integer id){
        return deptMapper.findDept(id);
    }

    public List<Dept> findDeptAll(){
        return deptMapper.findDeptAll();
    }

    public DeptVo findUserDept(Integer id)
    {
        return deptMapper.findUserDept(id);
    }
}

