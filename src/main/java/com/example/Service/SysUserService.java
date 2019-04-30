package com.example.Service;


import com.example.Dao.LoginTicketDao;
import com.example.Dao.SysUserDao;
import com.example.Entity.LoginTicket;
import com.example.Entity.SysUser;
import com.example.Utils.expressSafeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ql on 2019/4/29.
 * 职员服务类
 */
@Service
public class SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    LoginTicketDao loginTicketDAO;

    public Map<String,Object> register(String userName, String password,String address,String tel,String sex,Date birthday,int roldId,int status){
        Map<String,Object>map=new HashMap<>();

        if (StringUtils.isBlank(userName)){
            map.put("msg","用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }
        SysUser sysUser=sysUserDao.selectByUserName(userName);
        if (sysUser!=null){
            map.put("msg","用户已注册");
            return map;
        }
        sysUser=new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(expressSafeUtil.MD5(password));
        sysUser.setAddress(address);
        sysUser.setTel(tel);
        sysUser.setSex(sex);
        sysUser.setBirthday(birthday);
        sysUser.setRoleId(roldId);
        sysUser.setStatus(status);
        Date date=new Date();
        sysUser.setCreateDate(date);
        sysUser.setUpdateDate(date);
        sysUserDao.addUser(sysUser);
        return map;
    }
    public Map<String,Object> login(String userName, String password){
        Map<String,Object>map=new HashMap<>();

        if (StringUtils.isBlank(userName)){
            map.put("msg","用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)){
            map.put("msg","密码不能为空");
            return map;
        }
        SysUser sysUser=sysUserDao.selectByUserName(userName);
        if (sysUser==null){
            map.put("msg","用户不存在");
            return map;
        }
        if (!(expressSafeUtil.MD5(password).equals(sysUser.getPassword()))) {
            map.put("msg", "密码不正确");
            return map;
        }
        String ticket =addLoginTicket(sysUser.getId());
        map.put("ticket",ticket);
        map.put("userId",sysUser.getId());
        return map;
    }
    private String addLoginTicket(String userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
    public SysUser getUser(String id){
        SysUser user=sysUserDao.selectById(id);
        return user;
    }
    //登出操作
    public void logout(String ticket){

    }
    public SysUser selectByName(String username){
        return sysUserDao.selectByUserName(username);
    }

}
