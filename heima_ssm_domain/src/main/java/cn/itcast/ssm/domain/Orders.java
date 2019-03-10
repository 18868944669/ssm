package cn.itcast.ssm.domain;

import cn.itcast.ssm.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */

@Data
@ToString
public class Orders implements Serializable {
    private String id; //主键
    private String orderNum; //订单编号,唯一
    private Date orderTime; //下单时间
    private String orderTimeStr;
    private int orderStatus; //订单状态(0 未支付,1 已支付)
    private String orderStatusStr;
    private int peopleCount; //出行人数
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType; //支付方式(0 支付宝,1 微信,2 其他 )
    private String payTypeStr;
    private String orderDesc;// 订单描述

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm");

        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus == 0) {
            orderStatusStr = "未支付";
        }
        if (orderStatus == 1) {
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payType!=null){
            if (payType == 0) {
                payTypeStr = "支付宝";
            } else if (payType == 1) {
                payTypeStr="微信";
            }else if(payType == 2){
                payTypeStr="其他";
            }
        }
        return payTypeStr;
    }
}
