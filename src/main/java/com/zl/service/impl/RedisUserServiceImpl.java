package com.zl.service.impl;

import com.zl.pojo.UserDO;
import com.zl.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: FruitSales
 * @classname: RedisUserServiceImpl
 * @description:
 * @author: 朱林
 * @create: 2019-06-25 21:20
 **/
@Service
public class RedisUserServiceImpl implements RedisUserService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Resource(name = "redisTemplate")
    HashOperations<String,String,UserDO> hash; //redisTemplate.opsForHash()

    @Resource(name = "redisTemplate")
    ListOperations<String,String> list;

    @Override
    public void hashAdd() {
        UserDO userDO = new UserDO();
        userDO.setUserid("1");
        userDO.setUsername("张三");
        userDO.setPassword("000000");
        userDO.setRole(2);
        hash.put("userTest","1",userDO);
    }

    @Override
    public UserDO hashGet(Integer id) {
        boolean flag = hash.hasKey("userTest",id.toString());
        UserDO userDO = new UserDO();
        if(flag){
            userDO = hash.get("userTest",id.toString());
            System.out.println("Redis查询");
            return userDO;
        }else{
            userDO.setUserid(id.toString());
            userDO.setUsername("张三");
            userDO.setPassword("000000");
            userDO.setRole(2);
            hash.put("userTest",id.toString(),userDO);
            System.out.println("MYSQL查询");
            return userDO;
        }
    }

    @Override
    public void listPush() {
        String key = "news:top5";
        list.rightPushAll(key,"1","2","3","4","5");
    }

    @Override
    public List<String> listRange(Integer pageNum,Integer pageSize) {
        String key = "news:top5";
        Integer offSet = (pageNum - 1) * pageSize;
        Integer end = pageSize * pageNum - 1;
        List<String> list1 = list.range(key,offSet,end);
        return list1;
    }

    @Override
    public void listQueueInit(String cardId) {
        String key = "prod:" + cardId;  //初始化的key 还有多少任务要完成
        list.leftPushAll(key,"1商家出库","2快递员发件","3从北京到首都机场",
                "4首都机场到南京机场","5南京机场到建邺区","6建邺区到收货人");
    }

    @Override
    public void listQueueTouch(String cardId) {
        String key = "prod:" + cardId + ":succ";    //已完成任务队列
        list.rightPopAndLeftPush("prod:" + cardId,key);
    }

    @Override
    public List<String> listQueueSucc(String cardId) {
        String key = "prod:" + cardId + ":succ";    //已完成任务队列
        return list.range(key,0,-1);
    }

    @Override
    public List<String> listQueueWait(String cardId) {
        String key = "prod:" + cardId;  //初始化的key 还有多少任务要完成
        return list.range(key,0,-1);
    }


}
