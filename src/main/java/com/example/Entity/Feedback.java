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
 * 用户反馈表
 */
@Getter
@Setter
public class Feedback implements Serializable{
    private static final long serialVersionID=1L;
    @TableId(type = IdType.UUID)
    private String id;
    //用户名
    private String name;
    //用户电话
    private String tel;
    //反馈类型 1.订单反馈 2.意见反馈 3.Bug反馈
    private Integer type;
    //反馈信息
    private String message;
    //反馈状态 1.等待处理 2.已处理
    private Integer status;
    //负责人
    private String staffId;
    //处理结果
    private String result;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @TableField(update = "now()")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Override
    public String toString() {
        return "FeedBack{"+
                ",name="+name+
                ",tel="+tel+
                ",type="+type+
                ",message="+message+
                ",status="+status+
                ",staffId="+staffId+
                ",result="+result+
                ",createDate="+createDate+
                ",updateDate="+updateDate;
    }
}
