package cn.itcast.ssm.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class Permission {
    private String id; //主键
    private String permissionName; //权限名
    private String url; //资源路径
    private List<Role> roles;

}
