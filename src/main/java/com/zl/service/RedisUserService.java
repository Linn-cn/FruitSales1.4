package com.zl.service;

import com.zl.pojo.UserDO;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: RedisUserService
 * @description:
 * @author: 朱林
 * @create: 2019-06-25 21:20
 **/
public interface RedisUserService {

    void hashAdd();

    UserDO hashGet(Integer id);

    void listPush();

    List<String> listRange(Integer pageNum,Integer pageSize);

    void listQueueInit(String cardId);

    void listQueueTouch(String cardId);

    List<String> listQueueSucc(String cardId);

    List<String> listQueueWait(String cardId);
}
