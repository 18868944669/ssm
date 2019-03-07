package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll(int page, int size) throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    UserInfo findById(String userId) throws Exception;

    /**
     * 根据用户ID查询所有可以添加的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId)throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
