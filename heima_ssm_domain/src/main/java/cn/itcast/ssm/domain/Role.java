package cn.itcast.ssm.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

import java.util.List;
@Data
@ToString
public class Role {
    private String id; //主键
    private String roleName; //角色名
    private String roleDesc; //角色描述
    private List<Permission> permissions;
    private List<User> users;
}
