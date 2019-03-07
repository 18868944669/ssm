package cn.itcast.ssm.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 会员实体类
 */
@Data
@ToString
public class Member implements Serializable {
    private String id; //主键
    private String name; //姓名
    private String nickname; //昵称
    private String phoneNum; //电话号码
    private String email; //邮箱
}
