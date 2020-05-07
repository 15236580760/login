package com.rb.login.service.impl;

import com.rb.login.mapper.RoleMapper;
import com.rb.login.mapper.RoleResourceMapper;
import com.rb.login.model.entity.Resource;
import com.rb.login.model.entity.Role;
import com.rb.login.exception.BusinessException;
import com.rb.login.service.ResourceService;
import com.rb.login.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private ResourceService resourceService;

    @Override
    public int save(Role role) {
        if(null == role.getId()){
            //新建
            //验证名称是否重复。
            if(roleMapper.countByRoleName(role.getName()) > 0){
                throw new BusinessException("角色名称重复");
            }
            roleMapper.save(role);
        }else{
            //修改
            Role oldRole = roleMapper.findById(role.getId());
            if(null == oldRole){
                throw new BusinessException("角色信息不存在");
            }
            //当修改的名称和之前的名称不一样的时候，需要验证名称是否重复。
            if(!oldRole.getName().equals(role.getName())){
                if(roleMapper.countByRoleName(role.getName()) > 0){
                    throw new BusinessException("角色名称重复");
                }
            }
            roleMapper.update(role);
        }
        log.info("id:"+role.getId());
        return role.getId();
    }

    @Override
    public Role findById(Integer roleId) {
        return roleMapper.findById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public int count() {
        return roleMapper.count();
    }

    @Override
    public void delete(Integer id) {
        roleMapper.delete(id);
    }

    @Override
    public void grantResource2Role(Integer roleId,List<Integer> resourceIds) {
        //先删除该角色对应的所有资源信息
        roleResourceMapper.deleteResourceByRoleId(roleId);
        //保存现在的所有资源
        roleResourceMapper.save(roleId,resourceIds);
    }

    @Override
    public List<Resource> findResourceByRoleId(Integer roleId) {
        List<Integer> resourceIds = roleResourceMapper.findResourcesByRoleId(roleId);
        List<Resource> resources = new ArrayList<>();
        for(Integer resourceId : resourceIds){
            Resource resource = resourceService.findById(resourceId);
            resources.add(resource);
        }
        return resources;
    }

}
