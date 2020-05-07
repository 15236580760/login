package com.rb.login.mapper;

import com.rb.login.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int save(@Param("user") User user);

    /**
     * 更新用户信息
     * @param user
     */
    void update(@Param("user") User user);

    /**
     * 根据用户名称查询该名称对应的用户条数
     * @param userName
     * @return
     */
    int countByUserName(String userName);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return User用户信息
     */
    User findByUserName(String userName);

    /**
     * 根据用户
     * @param id
     * @return User 用户信息
     */
    User findById(Integer id);

    /**
     * 查询用户列表
     * @return List<User>
     */
    List<User> findByPage();

    /**
     * 查询用户条数
     * @return
     */
    int count();

    /**
     * 删除用户信息
     * @param userId
     */
    void delete(Integer userId);

}
