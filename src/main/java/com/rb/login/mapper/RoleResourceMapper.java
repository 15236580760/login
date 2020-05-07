package com.rb.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleResourceMapper {

    /**
     * 根据角色id删除该角色拥有的所有资源
     * @param roleId
     */
    void deleteResourceByRoleId(Integer roleId);

    /**
     * 根据角色id获取该角色拥有的所有资源id集合
     * @param roleId
     * @return
     */
    List<Integer> findResourcesByRoleId(Integer roleId);

    /**
     * 根据角色id和资源id集合保存 角色-资源信息表中的数据
     * @param roleId
     * @param resourceIds
     */
    void save(@Param("roleId")Integer roleId,@Param("resourceIds") List<Integer> resourceIds);

}
