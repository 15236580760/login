package com.rb.login.mapper;

import com.rb.login.model.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceMapper {
    /**
     * 保存资源信息
     * @param resource
     * @return
     */
    int save(@Param("resource") Resource resource);

    /**
     * 更新资源信息
     * @param resource
     */
    void update(@Param("resource") Resource resource);

    /**
     * 根据资源id获取资源详情
     * @param id
     * @return
     */
    Resource findById(Integer id);

    /**
     * 查询所有的资源信息
     * @return
     */
    List<Resource> findAll();

    /**
     * 查询总条数
     * @return
     */
    int count();

    /**
     * 删除资源
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据url和method 获取条数
     * @param url
     * @param method
     * @return
     */
    int countByUrlAndMethod(@Param("url") String url,@Param("method") String method);
}
