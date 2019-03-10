package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;

        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把自己的对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,
                true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
        }
        return authoritys;
    }

    /**
     * 查询所有用户信息
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        String encode_password = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode_password);

        userDao.save(userInfo);
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String userId) throws Exception {
        return userDao.findById(userId);
    }

    /**
     * 根据用户ID查询所有可以添加的角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
