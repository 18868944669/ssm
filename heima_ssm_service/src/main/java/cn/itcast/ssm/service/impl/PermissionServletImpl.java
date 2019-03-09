package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.PermissionDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionServletImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    /**
     * 查询所有资源权限
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    /**
     * 保存资源权限
     *
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
