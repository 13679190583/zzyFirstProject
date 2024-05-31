package com.example.zzyfirstproject;

import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.mapper.DeptMapper;
import com.example.zzyfirstproject.mapper.UserMapper;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisDemo {
    private static SqlSession getSqlSession() {
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    //用户查询全部
    @Test
    public void selectAllTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(user -> System.out.println(user));
    }

    //    @Test
    public void insertToUserTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "class2ZZZ", "753", 1, Date.from(Instant.now()), 4);
        Integer num = userMapper.insertToUser(user);
        System.out.println(num);
    }

    // @Test
    // public void updateTest(){
    //     SqlSession sqlSession = MyBatisDemo.getSqlSession();
    //     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //     User user = new User(13,"honghaier1111","753");
    //     Integer num = userMapper.update(user);
    //     System.out.println(num);
    // }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.delete(13);
        System.out.println(num);
    }
    //========================================

    //用户查询单个
    @Test
    public void selectByIdAndTableTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByIdAndTable("user", 5);
        System.out.println(user);
    }

    //（Map）通过账号密码查询
    @Test
    public void selectByUsernameAndPasswordTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //手动将参数放入到map中
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "猪八戒");
        map.put("password", "zhubajie");
        User user = userMapper.selectByUsernameAndPassword(map);
        System.out.println(user);
    }

    //为查询id为5的用户信息为一个Map
    @Test
    public void findUserToMapTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> users = userMapper.findUserToMap(5);
        System.out.println(users);
    }

    //查询全部用户信息为一个(Map)
    @Test
    public void findUserAllToMapTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> users = userMapper.findUserAllToMap();
        users.forEach(user -> System.out.println(user));
    }

    //MyBatis获取自增的主键
    // @Test
    // public void insertToOne(){
    //     try {
    //         SqlSession sqlSession = MyBatisDemo.getSqlSession();
    //         UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //         User user = new User(null,"牛魔王","789");
    //         Integer num = userMapper.insertToOne(user);
    //         System.out.println(num);
    //         System.out.println(user);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    //mybatis分页
    @Test
    public void selectUserLimitTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        int currentPage = 3;//第几页
        int pageSize = 3;//每页显示几个
        //起始位置 = (当前页-1)*页面大小
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<User> users = userMapper.selectUserLimit(map);
        users.forEach(user -> System.out.println(user));
    }

    //用户的部门信息
    @Test
    public void findUserDeptTest() {
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> list = userMapper.findUserDept();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void findDeptUsersTest() {
        try {
            SqlSession sqlSession = MyBatisDemo.getSqlSession();
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            DeptVo vo = deptMapper.findDeptUsers(2);
            System.out.println(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
