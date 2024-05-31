package com.example.zzyfirstproject.service;

import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.mapper.UserMapper;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    // public int insert(User user) throws Exception {
    //     userMapper.insertToOne(user);
    //     return 1;
    // }
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findUserAll(){
        return userMapper.selectAll();
    }

    public User findUser(Integer id){
        return userMapper.findUser(id);
    }
    // public List<User> findUser(){
    //     return userMapper.selectAll();
    // }

    public int addUser(User user)
    {
        return userMapper.insertToUser(user);
    }

    public int insertUserList(List<User> userList)
    {
        return userMapper.insertUserList(userList);
    }

    public int delterUser(Integer id)
    {
        return userMapper.delete(id);
    }

    public int delUserList(List<Integer> ids)
    {
        return userMapper.batchDelete(ids);
    }

    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    public List<UserVo> findUserDept()
    {
        return userMapper.findUserDept();
    }



}
