package com.example.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by ql on 2019/4/29.
 */
@Getter
@Setter
public class LoginTicket {
    private int id;
    private String userId;
    private Date expired;
    private int status;// 0有效，1无效
    private String ticket;
}
