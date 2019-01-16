package com.zl.test;


import com.zl.util.Constants;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @program: FruitSales
 * @description: 密码加密测试
 * @author: ZhuLlin
 * @create: 2019-01-08 15:49
 **/
public class MD5Test {

    @Test
    public void md5test(){
        Md5Hash md5Hash = new Md5Hash("000000","guonong",Constants.HASHITERATIONS);
        System.out.println(md5Hash.toString());
    }
}
