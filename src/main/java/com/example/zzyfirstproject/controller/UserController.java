package com.example.zzyfirstproject.controller;

import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.service.UserService;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    // logger.info("前端传来的参数为：" + user.toString());

    @Autowired
    private UserService userService;

    //insert

    @PostMapping("/insertUser")
    public String addUser(@RequestBody User user)
    {
        logger.debug(user.toString());
        System.out.println(user);
        if(userService.addUser(user) == 1)
        {
            return "添加成功";
        }
        return "添加失败";
    }

    @PostMapping("/batchInsert")
    public String insertList(@RequestBody List<User> user)
    {
        logger.debug(user.toString());
        for (User user1 : user){
            userService.addUser(user1);
        }
        return "添加成功";
    }
    //delete
    @DeleteMapping("/delterUser")
    public String delUser(@RequestParam("id") Integer id)
    {
        if(userService.delterUser(id) >= 1)
        {
            return "删除成功";
        }
        return "删除失败";
    }

    @PostMapping("batchDelete")
    public String deleteList(int[] id)
    {
        List<Integer> ids = new ArrayList<>();
        for (int i:
                id) {
            System.out.println(i);
            ids.add(i);
        }
        userService.delUserList(ids);

        return "删除成功";
    }
    //update
    @PostMapping("updateUser")
    public String updateUser(@RequestBody User user)
    {
        if(userService.updateUser(user) >= 1)
        {
            return "更新成功";
        }
        return "更新失败";
    }

    //查找用户全部信息
    @RequestMapping("/findUserAll")
    @ResponseBody
    public List<User> findUserAll(){

        return userService.findUserAll();
    }

    @GetMapping("findUser")
    public User findUser(int id)
    {
        return userService.findUser(id);
    }

    @GetMapping("findUserDept")
    public  List<UserVo> findUserDept()
    {
        return userService.findUserDept();

    }
}
