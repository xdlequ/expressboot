package com.example.Entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ql on 2019/4/28.
 */
@Setter
@Getter
public class Express implements Serializable{
    private static final long serialVersionUID=1L;
    private String id;
    //姓名
    private String name;
    //手机号
    private String tel;
    //快递信息
    private String message;
    //配送地址
    private String address;
    //订单备注
    private String remark;
    //订单状态
    private String status;
    //是否删除
    private boolean hasDelete;
    //配送人员
    private String staff;
    //配送人员备注
    private String staffRemark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @TableField(update = "now()")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Override
    public String toString() {
         return "Express{" +
                ", id=" + id +
                ", name=" + name +
                ", tel=" + tel +
                ", message=" + message +
                ", address=" + address +
                ", remark=" + remark +
                ", status=" + status +
                ", staff=" + staff +
                ", staffRemark=" + staffRemark +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                "}";
    }
}
