package com.example.Dao;

import com.example.Entity.Express;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ql on 2019/4/28.
 */
@Mapper
public interface ExpressDao {
    String TABLE_NAME="express";
    String INSERT_FIELDS="name,tel,message,address,remark,status,staff,create_date,update_date";
    String SELECT_FIELDS="id,name,tel,message,address,remark,status,staff,create_date,update_date";

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")","values(" +
            "#{name},#{tel},#{message},#{address},#{remark},#{status},#{staff},#{createDate},#{updateDate})"})
    String createExpress(Express express);
}
