package com.example.Entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ql on 2019/4/28.
 * 订单支付表
 */
@Getter
@Setter
public class ExpressPayment implements Serializable{
    private static final long serialVersionalID=1L;
    @TableId(type = IdType.UUID)
    private Integer id;
    //订单号
    private String expreddId;
    //支付方式
    private Integer type;
    //支付状态
    private Integer status;
    //线上支付金额
    private Double onlinePayment;
    //线上支付流水账号
    private String onlinePayNum;
    //线上收款方
    private String onlineSeller;
    //线下支付金额
    private Double offlinePayment;
    //备注
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @TableField(update = "now()")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

}
