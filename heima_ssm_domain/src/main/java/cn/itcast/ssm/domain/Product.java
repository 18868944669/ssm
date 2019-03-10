package cn.itcast.ssm.domain;

import cn.itcast.ssm.utils.DateUtils;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 产品实体类
 */
@Data
@ToString
public class Product implements Serializable {

    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getDepartureTimeStr() {
        if (departureTime!=null){
            departureTimeStr= DateUtils.dateToString(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            if (productStatus ==0){
                productStatusStr="关闭";
            }
            if (productStatus ==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }
}
