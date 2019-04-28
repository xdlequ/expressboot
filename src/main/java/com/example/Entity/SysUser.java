package com.example.Entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ql on 2019/4/28.
 */
@Component
@Setter
@Getter
public class SysUser implements Serializable{
    @TableId(type = IdType.UUID)
    private String id;
    private String userName;
    private String password;
    private String tel;
    private String sex;
    private String address;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //状态 0：在职 1：冻结 2：离职
    private Integer status;
    //权限 0：admin 1：staff
    private Integer roleId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @TableField(update = "now()")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Override
    public String toString() {
        return "SysUser{" +
                ", id=" + id +
                ", username=" + userName +
                ", password=" + password +
                ", tel=" + tel +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", roleId=" + roleId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                "}";
    }
}
