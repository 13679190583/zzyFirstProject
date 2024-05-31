package com.example.zzyfirstproject.controller;

import com.example.zzyfirstproject.entity.Dept;
import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.service.DeptService;
import com.example.zzyfirstproject.service.UserService;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeptController {

    @Autowired
    // private UserService userService;
    private DeptService deptService;

    //insert
    @PostMapping("/insertDept")
    public String insertDept(@RequestBody Dept dept)
    {
        System.out.println(dept);
        if(deptService.insertDept(dept) == 1)
        {
            return "添加成功";
        }
        return "添加失败";
    }

    @PostMapping("/batchInsertDept")
    public String batchInsertDept(@RequestBody List<Dept> dept)
    {
        for (Dept dept1 : dept){
            deptService.insertDept(dept1);
        }
        return "添加成功";
    }
    //delete
    @DeleteMapping("/delterDept")
    public String delterDept(@RequestParam("id") Integer id)
    {
        if(deptService.delterDept(id) >= 1)
        {
            return "删除成功";
        }
        return "删除失败";
    }

    // @DeleteMapping("batchDeleteDept")
    // public String batchDeleteDept(@RequestBody List<Integer> ids)
    // {
    //     deptService.batchDeleteDept(ids);
    //     return "删除成功";
    // }
    @PostMapping("batchDeleteDept")
    public String batchDeleteDept(int[] id)
    {
        List<Integer> ids = new ArrayList<>();
        for (int i:
                id) {
            System.out.println(i);
            ids.add(i);
        }
        deptService.batchDeleteDept(ids);

        return "删除成功";
    }
    //update
    @PostMapping("updateDept")
    public String updateUser(@RequestBody Dept dept)
    {
        if(deptService.updateDept(dept) >= 1)
        {
            return "更新成功";
        }
        return "更新失败";
    }

    //查找用户全部信息
    @GetMapping ("/findDeptAll")
    @ResponseBody
    public List<Dept> findDeptAll(){

        return deptService.findDeptAll();
    }

    @GetMapping("findDept")
    public Dept findDept(int id)
    {
        return deptService.findDept(id);
    }

    @GetMapping("findUserDeptList")
    public DeptVo findUserDept(Integer id)
    {
        return deptService.findUserDept(id);

    }
}
