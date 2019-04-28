package com.example.Dao;

import com.example.Entity.ExpressPayment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created by ql on 2019/4/28.
 */
@Mapper
public interface ExpressPaymentDao {
    String TABLE_NAME="express_payment";
    String INSERT_FIELDS="expressId,status,type,online_payment,online_payment_num,online_seller,offline_payment,remark,create_date,update_date";
    String SELECT_FIELDS="expressId,status,type,online_payment,online_payment_num,online_seller,offline_payment,remark,create_date,update_date";
    //创建线下订单
    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{expressId},#{status},#{type},#{onlinePayment},#{onlinePaymentNum},#{onlineSeller},#{offlinePayment},#{remark},#{createDate},#{updateDate}"})
    ExpressPayment createPayment(ExpressPayment expressPayment);


    boolean validAlipay(Map<String,String> params);

    boolean updateStatus(String orderId,int status,String...tradeNo);
}
