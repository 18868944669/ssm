package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有角色信息
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }

    /**
     * 添加角色
     *
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
    /**
     * 根据角色ID查询角色
     * @param roleId
     * @return
     */
    @Override
    public Role findById(String roleId)throws Exception {
        return roleDao.findById(roleId);
    }
    /**
     * 根据角色ID 查询所有可以添加的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception{
        return roleDao.findOtherPermissions(roleId);
    }
    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
