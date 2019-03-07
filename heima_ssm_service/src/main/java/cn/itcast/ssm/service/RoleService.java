package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    /**
     * 查询所有角色信息
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Role> findAll(int page, int size) throws Exception;

    /**
     * 添加角色
     *
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;

    /**
     * 根据角色ID查询角色
     * @param roleId
     * @return
     */
    Role findById(String roleId)throws Exception;

    /**
     * 根据角色ID 查询所有可以添加的权限
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermissions(String roleId)throws Exception;
    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
