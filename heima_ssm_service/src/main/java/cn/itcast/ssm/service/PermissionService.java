package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有资源权限
     *
     * @param page
     * @param size
     * @return
     */
    List<Permission> findAll(int page, int size) throws Exception;

    /**
     * 添加资源权限
     *
     * @param permission
     */
    void save(Permission permission) throws Exception;
}
