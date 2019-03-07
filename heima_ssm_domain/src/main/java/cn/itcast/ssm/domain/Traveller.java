package cn.itcast.ssm.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 旅客实体类
 */
@Data
@ToString
public class Traveller implements Serializable {
    private String id; //主键
    private String name;//姓名
    private String sex;//性别
    private String phoneNum;//手机号码
    private Integer credentialsType; //证件类型 (0 身份证,1 护照,2 军官证)
    private String credentialsTypeStr;
    private String credentialsNum; // 证件号码
    private Integer travellerType;//旅客类型(0 成人,1 儿童)
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "护照";
            } else if (credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }
        }

        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if (travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr = "成人";
            } else if (travellerType == 1) {
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }
}
