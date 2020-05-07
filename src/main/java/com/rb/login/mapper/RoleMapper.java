package com.rb.login.mapper;

import com.rb.login.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 保存角色信息
     * @param role
     * @return
     */
    int save(@Param("role") Role role);

    /**
     * 更新角色信息
     * @param role
     */
    void update(@Param("role") Role role);

    /**
     * 根据角色ID获取该角色详情
     * @param id
     * @return
     */
    Role findById(Integer id);

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
     * 根据角色名称查询角色条数
     * @param name
     * @return
     */
    int countByRoleName(String name);

    /**
     * 删除角色
     * @param id
     */
    void delete(Integer id);
}
