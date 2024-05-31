package com.example.zzyfirstproject.mapper;

import com.example.zzyfirstproject.entity.Dept;
import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {

    Integer insertDept(Dept dept);

    Integer batchInsertDept(List<Dept> deptList);

    Integer delete(Integer id);

    Integer batchDeleteDept(@Param("ids") List<Integer> ids);

    Integer updateDept(Dept dept);

    Dept findDept(int id);
    List<Dept> findDeptAll();

    DeptVo findUserDept(Integer id);
    /**
     * 查询当前部门信息，包括此部门对应的用户信息
     * @param id 部门编号
     * @return 部门信息+部门员工信息
     */
    DeptVo findDeptUsers(Integer id);
}

