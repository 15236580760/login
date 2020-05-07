package com.rb.login.controller;

import com.rb.login.exception.BusinessException;
import com.rb.login.model.bo.ResourceForm;
import com.rb.login.model.bo.RoleForm;
import com.rb.login.model.entity.Resource;
import com.rb.login.model.entity.Role;
import com.rb.login.model.entity.User;
import com.rb.login.model.vo.ResourceVo;
import com.rb.login.model.vo.RoleVo;
import com.rb.login.model.vo.UserVo;
import com.rb.login.service.ResourceService;
import com.rb.login.service.RoleService;
import com.rb.login.service.UserService;
import com.rb.login.model.bo.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.util.List;

import static com.rb.login.util.BeanCopyUtil.copy;
import static com.rb.login.util.BeanCopyUtil.copyList;

@RestController
@RequestMapping("/data")
@Slf4j
public class DataController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    //*******************************************用户接口

    // 新增/修改用户信息
    @PostMapping("/user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer save(@RequestBody UserForm userForm) {
        User user = copy(userForm,User.class);
        return userService.save(user);
    }

    //根据id获取用户详情
    @GetMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserVo findById(@PathVariable("id") @Min(value=1,message="id不能小于1")Integer userId) {
        User user = userService.findById(userId);
        if(null == user){
            throw new BusinessException("用户信息不存在");
        }
        log.info("userName:"+user.getUserName());
        UserVo vo = copy(user,UserVo.class);
        return vo;
    }

    //获取用户列表
    @GetMapping("/user")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserVo> findByPage() {
        List<User> users = userService.findByPage();
        List<UserVo> vos = copyList(users,UserVo.class);
        return vos;
    }

    //删除用户信息
    @DeleteMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer userId) {
        userService.delete(userId);
        return true;
    }

    //TODO:1、给用户赋予角色 2、根据用户id查询该用户的所有角色 3、根据用户id查询该用户的所有资源

    //给用户授权角色
    @PostMapping("/user/grant/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Boolean grantRole2User(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer userId,
                                  @RequestBody List<Integer> roleIds) {
        userService.grantRole2User(userId,roleIds);
        return true;
    }

    //获取用户的角色
    @PostMapping("/user/role/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Role> findRoleByUser(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer userId) {
        List<Role> roles = userService.findRoleByUserId(userId);
        return roles;
    }

    //*******************************************角色接口
    // 新增/修改角色信息
    @PostMapping("/role")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer saveRole(@RequestBody RoleForm roleForm) {
        Role role = copy(roleForm,Role.class);
        return roleService.save(role);
    }

    @GetMapping("/role/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public RoleVo findRoleById(@PathVariable("id") @Min(value=1,message="id不能小于1")Integer id) {
        Role role = roleService.findById(id);
        if(null == role){
            throw new BusinessException("角色信息不存在");
        }
        log.info("roleName:"+role.getName());
        RoleVo vo = copy(role,RoleVo.class);
        return vo;
    }

    @GetMapping("/role")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RoleVo> findAllRoles() {
        List<Role> roles = roleService.findAll();
        List<RoleVo> vos = copyList(roles,RoleVo.class);
        return vos;
    }

    @DeleteMapping("/role/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Boolean deleteRole(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer id) {
        roleService.delete(id);
        return true;
    }

    //TODO:1、给角色授权资源 2、根据角色id获取该角色的所有资源
    /**
     * 给角色授权资源信息
     * @param roleId
     * @param resourceIds
     * @return
     */
    @PostMapping("/role/grant/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Boolean grantResource2Role(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer roleId,
                                @RequestBody @NotEmpty(message = "id不可为空！") List<Integer> resourceIds) {
        roleService.grantResource2Role(roleId,resourceIds);
        return true;
    }

    /**
     * 根据角色ID获取该角色对应的所有资源
     * @param roleId
     * @return
     */
    @GetMapping("/role/resource/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Resource> findResourceByRole(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer roleId) {
        return roleService.findResourceByRoleId(roleId);
    }

    //*******************************************资源接口
    // 新增/修改资源信息
    @PostMapping("/resource")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer saveResource(@RequestBody ResourceForm resourceForm) {
        Resource resource = copy(resourceForm,Resource.class);
        return resourceService.save(resource);
    }

    @GetMapping("/resource/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResourceVo findResourceById(@PathVariable("id") @Min(value=1,message="id不能小于1")Integer id) {
        Resource resource = resourceService.findById(id);
        if(null == resource){
            throw new BusinessException("资源信息不存在");
        }
        log.info("resourceName:"+resource.getName());
        log.info("url:"+resource.getUrl());
        log.info("method:"+resource.getMethod());
        ResourceVo vo = copy(resource,ResourceVo.class);
        return vo;
    }

    @GetMapping("/resource")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ResourceVo> findAllResources() {
        List<Resource> resources = resourceService.findAll();
        List<ResourceVo> vos = copyList(resources,ResourceVo.class);
        return vos;
    }

    @DeleteMapping("/resource/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Boolean deleteResource(@PathVariable("id") @Min(value=1,message="id不能小于1") Integer id) {
        resourceService.delete(id);
        return true;
    }
}
