package com.rb.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    /**
     * 给用户授权角色
     * @param userId
     * @param roleIds
     */
    void save(@Param("userId")Integer userId, @Param("roleIds")List<Integer> roleIds);

    /**
     * 根据用户id获取该用户下的所有角色
     * @param userId
     * @return
     */
    List<Integer> findRoleIdsByUserId(Integer userId);

    /**
     * 根据用户id删除该用户的所有角色
     * @param userId
     */
    void deleteByUserId(Integer userId);
}
