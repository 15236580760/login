package com.rb.login.service;

import com.rb.login.model.entity.Resource;
import com.rb.login.model.entity.Role;
import com.rb.login.model.entity.User;
import com.rb.login.model.entity.LoginRecord;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    Integer save(User user);

    /**
     * 根据用户名称查询该名称对应的用户条数
     * @param userName
     * @return
     */
    long countByUserName(String userName);

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
     * 删除用户
     * @param userId
     */
    void delete(Integer userId);

    /**
     * 给用户授权角色
     * @param userId
     * @param roleIds
     */
    void grantRole2User(Integer userId,List<Integer> roleIds);

    /**
     * 根据用户id查询该用户所拥有的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);

    /**
     * 根据用户id查询该用户所有的资源信息
     * @param userId
     * @return
     */
    List<Resource> findResourceByUserId(Integer userId);

    /**
     * 根据用户访问的url和tokenId判断该用户是否拥有访问该url的资格
     * @param url
     * @param tokenId
     * @param method
     * @return
     */
    boolean checkLoginUser(String url,String tokenId,String method);

    /**
     * 保存用户和tokenId
     * @param userName
     * @param tokenId
     */
    void saveLogin(String userName,String tokenId);

    /**
     * 用户登录次数+1
     * @param userName
     */
    void addLogin(String userName);

    /**
     * 查询该用户该token条数
     * @param userName
     * @param tokenId
     * @return
     */
    Integer countLogin(String userName,String tokenId);

    /**
     * 获取所有的登录信息
     * @return
     */
    List<LoginRecord> findAllLoginInfo();

}
