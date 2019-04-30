package com.example.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by ql on 2019/4/29.
 */
public class expressSafeUtil {
    private static final Logger log=LoggerFactory.getLogger(expressSafeUtil.class);
    public static String MD5(String key){
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9'};
        try{
            byte[]btInput=key.getBytes();
            //获得MD5摘要算法的MessageDigest对象
            MessageDigest mdInst=MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[]md=mdInst.digest();
            //把密文转化为十六进制的字符串
            int j=md.length;
            char str[]=new char[j*2];
            int k=0;
            for (int i=0;i<j;i++){
                byte byte0=md[i];
                str[k++]=hexDigits[byte0>>>4 & 0xf];
                str[k++]=hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(Exception e){
            log.error("生成md5失败",e);
            return null;
        }
    }
}
