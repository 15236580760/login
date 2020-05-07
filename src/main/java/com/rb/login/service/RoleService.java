package com.rb.login.service;

import com.rb.login.model.entity.Resource;
import com.rb.login.model.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    int save(@Param("role") Role role);

    /**
     * 根据角色ID获取该角色详情
     * @param roleId
     * @return
     */
    Role findById(Integer roleId);

    /**
     * 查询角色信息
     * @return
     */
    List<Role> findAll();

    /**
     * 查询角色条数
     * @return
     */
    int count();

    /**
     * 删除角色
     * @param id
     */
    void delete(Integer id);

    /**
     * 将资源授权给角色
     * @param roleId
     * @param resourceIds
     */
    void grantResource2Role(Integer roleId,List<Integer> resourceIds);

    /**
     * 根据roleId获取该角色对应的所有资源
     * @param roleId
     * @return
     */
    List<Resource> findResourceByRoleId(Integer roleId);
}
