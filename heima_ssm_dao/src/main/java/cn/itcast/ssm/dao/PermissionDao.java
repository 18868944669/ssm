package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    /**
     * 根据角色id查询所有权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleID=#{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查询所有资源权限
     *
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     * 添加资源权限
     *
     * @param permission
     */
    @Insert("insert into permission(permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission);
}
