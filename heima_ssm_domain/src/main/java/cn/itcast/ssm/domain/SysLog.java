package cn.itcast.ssm.domain;

import cn.itcast.ssm.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SysLog {
    private String id; //主键
    private Date visitTime; //访问时间
    private String visitTimeStr;
    private String username; //操作者姓名
    private String ip; //访问ip
    private String url; //访问资源url
    private Long executionTime; //执行时长
    private String method; //执行方法

    public String getVisitTimeStr() {
        visitTimeStr=DateUtils.dateToString(visitTime,"yyyy-MM-dd HH:mm:ss");
        return visitTimeStr;
    }
}
