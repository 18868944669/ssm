package cn.itcast.ssm.domain;
//与数据库中的user对应

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UserInfo {
    private String id; //主键
    private String username; //用户名
    private String email; //邮箱,非空,唯一
    private String password; //密码,加密
    private String phoneNum;//电话
    private int status; //状态 0 未开启 1 开启
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status==0){
            statusStr="未开启";
        }
        if (status==1){
            statusStr="开启";
        }
        return statusStr;
    }
}
