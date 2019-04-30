package com.example.Dao;

import com.example.Entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ql on 2019/4/28.
 */
@Mapper
public interface SysUserDao {
    String TABLE_NAME="sys_user";
    String INSERT_FIELDS="username,password,tel,sex,address,birthday,role_id,status,create_date,update_date";
    String SELECT_FIELDS="id,username,password,tel,sex,address,birthday,role_id,status,create_date,update_date";

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{username},#{password}," +
            "#{tel},#{sex},#{address},#{birthday},#{roleId},#{status},#{createDate},#{updateDate})"})
    int addUser(SysUser user);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id=#{id}"})
    SysUser selectById(String id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where username=#{userName}"})
    SysUser selectByUserName(String userName);

}
