package com.example.zzyfirstproject.mapper;

import com.example.zzyfirstproject.controller.UserController;
import com.example.zzyfirstproject.entity.User;
import com.example.zzyfirstproject.vo.DeptVo;
import com.example.zzyfirstproject.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //@Select("select * from user")
    List<User> selectAll();

    User findUser(int id);

    List<UserVo> findUserDept();

    //@Select("select * from user where id = #{id}")
    User selectById(Integer id);

    // @Insert("insert into user(user_name,password) values(#{userName},#{password})")
    // @Insert("INSERT INTO `user`(`user_name`, `password`, `gender`, `birthday`, `dept_id`) " +
    //         "VALUES (#{userName}, #{password}, #{gender}, #{birthday}, #{deptId})")
    Integer insertToUser(User user);

    Integer insertUserList(List<User> userList);

    //@Update("update user set user_name=#{userName} where id=#{id}")
    Integer updateUser(User user);

    //@Delete("delete from user where id=#{id}")
    Integer delete(Integer id);

    Integer batchDelete(@Param("ids") List<Integer> ids);

    //=========================
    /**
     * 通过用户传递的表名和id来查询具体数据
     * @param table 表名
     * @param id 用户传递的id
     * @return 返回具体用户数据
     */
    @Select("select * from ${tableX} where id = #{idX}")
    User selectByIdAndTable(@Param("tableX") String table, @Param("idX") Integer id);

    /**
     * 通过Map查询用户数据
     * @param map 需要获得的参数
     * @return 查询结果
     */
    @Select("select * from user where user_name=#{user_name} and password=#{password}")
    User selectByUsernameAndPassword(Map<String,Object> map);

    /**
     * 根据用户id查询数据，并且将数据转换为Map
     * @param id 参数
     * @return 转换的Map数据
     */
    @Select("select * from user where id=#{id}")
    Map<String,Object> findUserToMap(Integer id);

    /**
     * 查询user表中全部的数据，并且转换为map
     * @return list集合中存放Map
     */
    // @Select("select * from user")
    List<Map<String,Object>> findUserAllToMap();
//    @MapKey("id")
//    Map<String,Object> findUserAllToMap();

    //MyBatis获取自增的主键
    @Insert("insert into user(user_name,password) values(#{userName},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertToOne(User user);

    @Select("select * from user limit #{startIndex},#{pageSize}")
    List<User> selectUserLimit(Map<String,Integer> map);



    @Select("SELECT user_name, gender, birthday, dept_id, dept_name, description, address FROM `user` RIGHT JOIN `department` ON dept_id = `department`.id")
    List<DeptVo> findUserDeptAll();

}
