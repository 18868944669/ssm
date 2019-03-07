package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface RoleDao {
    /**
     * 根据用户ID查询角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleID from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id",
                    many = @Many(select = "cn.itcast.ssm.dao.PermissionDao.findPermissionByRoleId")),
            @Result(property = "users", column = "id",
                    many = @Many(select = "cn.itcast.ssm.dao.TravellerDao.findByOrdersId"))

    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有角色信息
     *
     * @return
     */
    @Select("select * from role ")
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 根据角色id查询角色
     *
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId)throws Exception;

    /**
     * 根据角色ID 查询所有可以添加的权限
     *
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId)throws Exception;
    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission(roleId,permissionId)values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId)throws Exception;
}
